package com.linux.stw.character.weapon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.linux.stw.character.Playable;
import com.linux.stw.util.CollisionManager;

/**
 * Created by nahum on 11/02/17.
 */
public class BulletBoss extends Bullet
{
    private Weapon weapon;
    private int n;
    private static Texture tex = new Texture(Gdx.files.internal("data/enemy/tomato/bullet.png"));

    private Vector2 v;
    private Vector2 vector2;

    long time;

    public BulletBoss(Playable playable, Weapon weapon, int n, Vector2 v)
    {
        this.player = playable;
        this.weapon = weapon;
        this.n=n;

        this.position = new Vector2(player.getPosition().x+28, playable.getPosition().y-40);
        texture = new Texture("data/enemy/tomato/bullet.png");
        rectangle = new Rectangle(position.x, position.y, tex.getWidth(), tex.getHeight());

        time = System.currentTimeMillis();

        CollisionManager.getInstance().add(this.getRectangle());

        vector2 = new Vector2();
        vector2.x = (position.x - v.x);
        vector2.y = (position.y - v.y);
        vector2.nor();

        this.v = v;
    }

    public BulletBoss(Playable playable, Weapon weapon, int n)
    {
        this.player = playable;
        this.weapon = weapon;
        this.n=n;

        this.position = new Vector2(player.getPosition().x+28, playable.getPosition().y-40);
        texture = new Texture("data/enemy/tomato/bullet.png");
        rectangle = new Rectangle(position.x, position.y, tex.getWidth(), tex.getHeight());

        time = System.currentTimeMillis();

        CollisionManager.getInstance().add(this.getRectangle());

        this.vector2 = new Vector2(MathUtils.random(-1.0f, 1.0f), 1);
    }

    @Override
    public void update(float delta)
    {
        long timeActual = System.currentTimeMillis();

        if ((timeActual - time) > 3000)
        {
            time = System.currentTimeMillis();
            weapon.bullets.removeValue(this, true);
            dispose();
        }
        else
        {
            float speed = MathUtils.random(2.0f, 10.0f);
            position.x -= vector2.x * speed;
            position.y -= vector2.y * speed;
            rectangle.setPosition(position);
        }
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(texture, position.x, position.y);
    }

    @Override
    public void dispose() {
        tex.dispose();
    }
}
