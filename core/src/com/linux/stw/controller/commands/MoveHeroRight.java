/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.controller.commands;

import com.linux.stw.character.hero.Hero;

/**
 * Created by nahum on 10/02/17.
 */
public class MoveHeroRight implements CommandControl
{
    @Override
    public void execute(Object obj) {
        Hero hero = (Hero) obj;
        hero.getPosition().add(10, 0);
        hero.getRectangle().x = hero.getPosition().x;
        hero.getRectangle().y = hero.getPosition().y;
    }
}
