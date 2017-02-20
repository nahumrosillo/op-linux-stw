package com.linux.stw.character.hero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.linux.stw.character.Experience;
import com.linux.stw.character.Playable;
import com.linux.stw.character.Stats;
import com.linux.stw.character.weapon.WeaponTest;
import com.linux.stw.controller.PollingController;
import com.linux.stw.controller.ProfileControl;
import com.linux.stw.controller.commands.*;
import com.linux.stw.util.CollisionManager;

/**
 * Created by nahum on 08/02/17.
 */
public class Hero extends Playable
{
    public Hero() {}

    public Hero(Stats stats, Experience experience)
    {
        this.stats = stats;
        this.experience = experience;
        this.position = new Vector2(220,20);

        weapon = new WeaponTest(this);
    }

    @Override
    public void setController(PollingController controller) {
        this.controller = controller;

        ProfileControl profileControl = new ProfileControl(this);
        profileControl.setButtonA(new ShootTest());
        profileControl.setButtonRB(new LevelUp());
        profileControl.setAxisLeftY(new MoveHeroAxisY());
        profileControl.setAxisLeftX(new MoveHeroAxisX());

        profileControl.setPadUp(new MoveHeroUp());
        profileControl.setPadDown(new MoveHeroDown());
        profileControl.setPadLeft(new MoveHeroLeft());
        profileControl.setPadRight(new MoveHeroRight());

        this.controller.setProfileControl(profileControl);
        this.controller.setController(Controllers.getControllers().first());

        CollisionManager.getInstance().setPlayer(this);
    }

    @Override
    public void update(float delta)
    {
        controller.update();
        weapon.update(delta);

        position.x = MathUtils.clamp(position.x, 0, Gdx.graphics.getWidth()-getTexture().getWidth());
        position.y = MathUtils.clamp(position.y, 0, Gdx.graphics.getHeight()-getTexture().getHeight());

        rectangle.setPosition(position);
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
