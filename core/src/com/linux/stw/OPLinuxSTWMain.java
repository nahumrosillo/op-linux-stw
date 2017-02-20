package com.linux.stw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.linux.stw.character.Playable;
import com.linux.stw.character.hero.Hero;
import com.linux.stw.character.weapon.Bullet;
import com.linux.stw.controller.PollingController;
import com.linux.stw.controller.XBox360PadPolling;
import com.linux.stw.util.CollisionManager;
import com.linux.stw.util.factory.*;

public class OPLinuxSTWMain extends ApplicationAdapter {

    PollingController mando;
    Hero hero;
    Playable mutant;
    SpriteBatch batch;

    public static OrthographicCamera camera;
    Viewport viewport;
	
	@Override
	public void create ()
    {
        camera = new OrthographicCamera();
        camera.translate(400*0.5f, 800*0.5f);
        viewport = new FitViewport(400, 800, camera);

        batch = new SpriteBatch();
        hero = HeroFactory.createHero(HeroType.TUX, 1);
        mando = new XBox360PadPolling();
        hero.setController(mando);

        mutant = MutantFactory.createMutant(MutantType.TOMATO, 5);
        mutant.setPlayer(hero);
	}

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
	public void render ()
    {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		CollisionManager.getInstance().clear();

		hero.update(Gdx.graphics.getDeltaTime());
		mutant.update(Gdx.graphics.getDeltaTime());
        CollisionManager.getInstance().update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        hero.draw(batch);
        mutant.draw(batch);
        batch.end();

        CollisionManager.getInstance().update();


        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (Bullet bullet : hero.getWeapon().getBullets())
        {
            shapeRenderer.rect(bullet.getRectangle().x,
                    bullet.getRectangle().y,
                    bullet.getRectangle().width,
                    bullet.getRectangle().height);
        }

        for (Bullet bullet : mutant.getWeapon().getBullets())
        {
            shapeRenderer.rect(bullet.getRectangle().x,
                    bullet.getRectangle().y,
                    bullet.getRectangle().width,
                    bullet.getRectangle().height);
        }
        shapeRenderer.end();

	}
	
	@Override
	public void dispose ()
    {
        hero.dispose();
        mutant.dispose();
	}
}
