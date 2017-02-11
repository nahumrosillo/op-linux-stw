/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.character.player;

import com.badlogic.gdx.controllers.Controllers;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.linux.stw.character.Experience;
import com.linux.stw.character.Playable;
import com.linux.stw.character.Stats;
import com.linux.stw.character.weapon.WeaponTest;
import com.linux.stw.controller.PollingController;
import com.linux.stw.controller.ProfileControl;
import com.linux.stw.controller.commands.*;

/**
 * Created by nahum on 08/02/17.
 */
public class Hero extends Playable
{
    private PollingController mando;

    public Hero(Stats stats, Experience experience)
    {
        this.stats = stats;
        this.experience = experience;
        this.position = new Vector2(0,0);

        weapon = new WeaponTest(this);
    }

    public void setController(PollingController controller)
    {
        this.mando = controller;

        ProfileControl profileControl = new ProfileControl(this);
        profileControl.setButtonA(new ShootTest());
        profileControl.setAxisLeftY(new MoveHeroAxisY());
        profileControl.setAxisLeftX(new MoveHeroAxisX());

        profileControl.setPadUp(new MoveHeroUp());
        profileControl.setPadDown(new MoveHeroDown());
        profileControl.setPadLeft(new MoveHeroLeft());
        profileControl.setPadRight(new MoveHeroRight());

        this.mando.setProfileControl(profileControl);
        this.mando.setController(Controllers.getControllers().first());
    }

    @Override
    public void update(float delta)
    {
        mando.update();
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
