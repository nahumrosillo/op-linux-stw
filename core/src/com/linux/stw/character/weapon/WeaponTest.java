package com.linux.stw.character.weapon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.linux.stw.character.Playable;

/**
 * Created by nahum on 11/02/17.
 */
public class WeaponTest extends Weapon
{
    public WeaponTest(Playable playable)
    {
        player = playable;
        bullets = new Array<Bullet>();

    }
    @Override
    public void update(float delta)
    {
        if (bullets.size >= 200)
            bullets.removeRange(150, 199);

        for(Bullet bullet : bullets)
            bullet.update(delta);
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
        bullets.add(new BulletTest(player, this, 5));
        bullets.add(new BulletTest(player, this, -5));
        bullets.add(new BulletTest(player, this, 0));
    }

    @Override
    public void dispose() {
        for (Bullet bullet : bullets)
            bullet.dispose();
    }
}
