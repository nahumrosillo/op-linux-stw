package com.linux.stw.controller.commands;

import com.linux.stw.character.hero.Hero;

/**
 * Created by nahum on 10/02/17.
 */
public class MoveHeroUp implements CommandControl
{
    @Override
    public void execute(Object obj) {
        Hero hero = (Hero) obj;
        hero.getPosition().add(0, 10);
        hero.getRectangle().x = hero.getPosition().x;
        hero.getRectangle().y = hero.getPosition().y;
    }
}
