package com.linux.stw.character;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;
import com.linux.stw.character.weapon.Weapon;

/**
 * Created by nahum on 08/02/17.
 */
public abstract class Playable implements Disposable
{
    protected String name;

    protected Stats stats;
    protected Experience experience;

    protected Rectangle rectangle;
    protected Texture texture;
    protected Vector2 position;

    protected Weapon weapon;

    public abstract void update(float delta);
    public abstract void draw(SpriteBatch batch);

    @Override
    public void dispose ()
    {
        texture.dispose();
        weapon.dispose();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }

    public Experience getExperience() {
        return experience;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        String s;

        s = "--- Playable ---\n";
        s += "Name: " + name +"\n";
        s += stats.toString();
        s += experience.toString();
        s += "---------------\n";

        return s;
    }
}
