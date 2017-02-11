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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.linux.stw.character.Playable;

/**
 * Created by nahum on 11/02/17.
 */
public class BulletTest extends Bullet
{
    private Weapon weapon;
    private int n;
    private int counter = 0;
    private static Texture tex = new Texture(Gdx.files.internal("bullet.png"));

    long time;

    public BulletTest(Playable playable, Weapon weapon)
    {
        this.player = playable;
        this.weapon = weapon;

        this.position = new Vector2(player.getPosition().x-110, playable.getPosition().y+35);


        time = System.currentTimeMillis();
    }

    public BulletTest(Playable playable, Weapon weapon, int n)
    {
        this.player = playable;
        this.weapon = weapon;
        this.n=n;

        this.position = new Vector2(player.getPosition().x-50, playable.getPosition().y+25);
        texture = new Texture("bullet.png");

        time = System.currentTimeMillis();
    }

    @Override
    public void update(float delta)
    {
        long timeActual = System.currentTimeMillis();

        if ((timeActual - time) > 500)
        {
            weapon.bullets.removeValue(this, true);
            dispose();
        }

        position.y += (20);
        counter += n;

        int num = 80;
        if(counter >= num || counter <= -num)
            position.x -= n;
        else
            position.x += n;
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
