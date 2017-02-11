package com.linux.stw.character.weapon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.linux.stw.character.Playable;

/**
 * Created by nahum on 11/02/17.
 */
public abstract class Weapon implements Disposable
{
    protected Playable player;
    protected Array<Bullet> bullets;

    public abstract void update(float delta);
    public abstract void draw(SpriteBatch batch);

    public abstract void shoot();

}
