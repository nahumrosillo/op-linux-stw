package com.linux.stw.controller.commands;

import com.linux.stw.character.player.Hero;

/**
 * Created by nahum on 10/02/17.
 */
public class MoveHeroUp implements CommandControl
{
    @Override
    public void execute(Object obj) {
        Hero hero = (Hero) obj;
        hero.getPosition().add(0, 10);
    }
}
