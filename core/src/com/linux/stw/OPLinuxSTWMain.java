package com.linux.stw;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.linux.stw.character.player.Hero;
import com.linux.stw.controller.PollingController;
import com.linux.stw.controller.XBox360PadPolling;
import com.linux.stw.util.factory.ExperienceType;
import com.linux.stw.util.factory.HeroType;
import com.linux.stw.util.factory.PlayableFactory;

public class OPLinuxSTWMain extends ApplicationAdapter {

    PollingController mando;
    Hero hero;
    SpriteBatch batch;
	
	@Override
	public void create ()
    {
        batch = new SpriteBatch();
        hero = PlayableFactory.createHero(HeroType.TUX, ExperienceType.LINEAL, 5);
        hero.setTexture(new Texture(Gdx.files.internal("gun.png")));

        mando = new XBox360PadPolling();
        hero.setController(mando);
	}

	@Override
	public void render ()
    {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		hero.update(Gdx.graphics.getDeltaTime());

		batch.begin();
		hero.draw(batch);
		batch.end();

	}
	
	@Override
	public void dispose ()
    {
        hero.dispose();
	}
}
