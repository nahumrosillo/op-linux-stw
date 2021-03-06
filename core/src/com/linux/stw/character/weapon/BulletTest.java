/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

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
public class BulletTest extends Bullet
{
    private Weapon weapon;
    private int n;
    private int counter = 0;
    private static Texture tex = new Texture(Gdx.files.internal("bullet.png"));

    private Vector2 v;
    private Vector2 vector2;

    long time;

    public BulletTest(Playable playable, Weapon weapon)
    {
        this.player = playable;
        this.weapon = weapon;

        this.position = new Vector2(player.getPosition().x, playable.getPosition().y);
        rectangle = new Rectangle(position.x, position.y, tex.getWidth(), tex.getHeight());


        time = System.currentTimeMillis();
    }

    public BulletTest(Playable playable, Weapon weapon, int n, Vector2 v)
    {
        this.player = playable;
        this.weapon = weapon;
        this.n=n;

        this.position = new Vector2(player.getPosition().x+28, playable.getPosition().y+60);
        texture = new Texture("bullet.png");
        rectangle = new Rectangle(position.x, position.y, tex.getWidth(), tex.getHeight());

        time = System.currentTimeMillis();

        CollisionManager.getInstance().add(this.getRectangle());

        vector2 = new Vector2();
        vector2.x = (position.x - v.x);
        vector2.y = (position.y - v.y);
        vector2.nor();

        this.v = v;
    }

    public BulletTest(Playable playable, Weapon weapon, int n)
    {
        this.player = playable;
        this.weapon = weapon;
        this.n=n;

        this.position = new Vector2(player.getPosition().x+28, playable.getPosition().y+80);
        texture = new Texture("bullet.png");
        rectangle = new Rectangle(position.x, position.y, tex.getWidth(), tex.getHeight());

        time = System.currentTimeMillis();

        CollisionManager.getInstance().add(this.getRectangle());
        v = null;
    }

    @Override
    public void update(float delta)
    {
        long timeActual = System.currentTimeMillis();

        if ((timeActual - time) > 500)
        {
            time = System.currentTimeMillis();
            weapon.bullets.removeValue(this, true);
            dispose();
        }
        else
        {
            position.y += 18;
            counter += n;
            int num = 80;
            if (counter >= num || counter <= -num)
                position.x -= n;
            else
                position.x += n;

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
