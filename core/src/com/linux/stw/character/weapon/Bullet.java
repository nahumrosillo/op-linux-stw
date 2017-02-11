package com.linux.stw.character.weapon;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.linux.stw.character.Playable;

/**
 * Created by nahum on 11/02/17.
 */
public abstract class Bullet implements Disposable
{
    protected Playable player;
    protected Texture texture;
    protected Vector2 position;

    public abstract void update(float delta);
    public abstract void draw(SpriteBatch batch);
}
