/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.controller.commands;

import com.badlogic.gdx.math.Vector2;
import com.linux.stw.character.player.Hero;

/**
 * Created by nahum on 10/02/17.
 */
public class MoveHeroAxisX implements AxisControl
{
    @Override
    public void update(Object obj, float value)
    {
        Hero hero = (Hero) obj;
        hero.getPosition().add(new Vector2(10 * value, 0));
    }
}
