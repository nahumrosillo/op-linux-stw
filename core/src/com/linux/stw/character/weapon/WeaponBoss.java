/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.character.weapon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.linux.stw.character.Playable;
import com.linux.stw.util.CollisionManager;

/**
 * Created by nahum on 11/02/17.
 */
public class WeaponBoss extends Weapon
{
    public WeaponBoss(Playable playable)
    {
        player = playable;
        bullets = new Array<Bullet>();

    }
    @Override
    public void update(float delta)
    {
        if (bullets.size >= 200)
            bullets.removeRange(0, 1);

        for(Bullet bullet : bullets)
        {
            bullet.update(delta);
            CollisionManager.getInstance().add(bullet.getRectangle());
        }

    }

    @Override
    public void draw(SpriteBatch batch)
    {
        for(Bullet bullet : bullets)
            bullet.draw(batch);
    }

    @Override
    public void shoot()
    {

        bullets.add(new BulletBoss(player, this, 5));
        bullets.add(new BulletBoss(player, this, -5));
        bullets.add(new BulletBoss(player, this, 0));
    }

    @Override
    public void shoot(Vector2 v)
    {
        bullets.add(new BulletBoss(player, this, MathUtils.random(-2, 3), v));
        bullets.add(new BulletBoss(player, this, 5));
        bullets.add(new BulletBoss(player, this, -5));
        bullets.add(new BulletBoss(player, this, 0));

    }

    @Override
    public void dispose() {
        for (Bullet bullet : bullets)
            bullet.dispose();
    }
}
