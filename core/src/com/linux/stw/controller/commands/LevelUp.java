/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.controller.commands;

import com.badlogic.gdx.Gdx;
import com.linux.stw.character.Playable;
import com.linux.stw.character.hero.Hero;

/**
 * Created by nahum on 13/02/17.
 */
public class LevelUp implements CommandControl
{
    @Override
    public void execute(Object obj)
    {
        Playable playable = (Playable) obj;
        playable.getExperience().levelUp();
        Gdx.app.log("LevelUp Command", "Level Up! " + playable.getExperience().getCurrentLevel());
        Gdx.app.log("Tag"," " +  250 / playable.getStats().getSpd());
    }
}
