package com.linux.stw.character.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.linux.stw.character.Experience;
import com.linux.stw.character.Playable;
import com.linux.stw.character.Stats;
import com.linux.stw.character.weapon.WeaponBoss;
import com.linux.stw.character.weapon.WeaponTest;
import com.linux.stw.controller.PollingController;
import com.linux.stw.util.CollisionManager;

/**
 * Created by nahum on 09/02/17.
 */
public class Mutant extends Playable
{
    long startTime;
    long time;

    public Mutant() {}

    public Mutant(Stats stats, Experience experience)
    {
        this.stats = stats;
        this.experience = experience;
        this.position = new Vector2(200, 700);

        weapon = new WeaponBoss(this);
        time = 0;
        startTime = System.currentTimeMillis();
    }

    @Override
    public void update(float delta)
    {
        CollisionManager.getInstance().addPlayable(this);

        time = System.currentTimeMillis();
        if ((time - startTime) >= 1000)
        {
            startTime = System.currentTimeMillis();
            weapon.shoot(player.getPosition());
            weapon.shoot(new Vector2(player.getPosition().x+5, player.getPosition().y+5));
            weapon.shoot(new Vector2(player.getPosition().x-5, player.getPosition().y-5));
        }

        weapon.update(delta);
    }

    @Override
    public void draw(SpriteBatch batch)
    {
        batch.draw(
                texture,
                position.x, position.y,
                texture.getWidth(), texture.getHeight());
        weapon.draw(batch);
    }


}