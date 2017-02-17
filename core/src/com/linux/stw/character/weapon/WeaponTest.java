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
public class WeaponTest extends Weapon
{
    private long time, endTime;
    private boolean activate;
    public WeaponTest(Playable playable)
    {
        player = playable;
        bullets = new Array<Bullet>();
        endTime = 0;
        time = System.currentTimeMillis();
        activate = true;

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
        if (activate)
        {
            activate = false;

            bullets.add(new BulletTest(player, this, 5));
            bullets.add(new BulletTest(player, this, -5));
            bullets.add(new BulletTest(player, this, 0));
        }
        else
        {
            time = System.currentTimeMillis();

            if ((time - endTime) > (250 / player.getStats().getSpd()))
            {
                endTime = System.currentTimeMillis();
                activate = true;
            }
        }
    }

    @Override
    public void shoot(Vector2 v)
    {
        if (activate)
        {
            activate = false;
            bullets.add(new BulletTest(player, this, MathUtils.random(-2, 3), v));
        }
        else
        {
            time = System.currentTimeMillis();

            if ((time - endTime) > 100)
            {
                endTime = System.currentTimeMillis();
                activate = true;
            }
        }

    }

    @Override
    public void dispose() {
        for (Bullet bullet : bullets)
            bullet.dispose();
    }
}
