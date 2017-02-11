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

/**
 * Created by nahum on 11/02/17.
 */
public class ShootTest implements CommandControl
{
    @Override
    public void execute(Object obj)
    {
        Playable player = (Playable) obj;
        player.getWeapon().shoot();
    }
}
