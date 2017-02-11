/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.character.enemy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.linux.stw.character.Experience;
import com.linux.stw.character.Playable;
import com.linux.stw.character.Stats;

/**
 * Created by nahum on 09/02/17.
 */
public class Mutant extends Playable
{
    public Mutant() {}

    public Mutant(Stats stats, Experience experience)
    {
        this.stats = stats;
        this.experience = experience;
    }


    @Override
    public void update(float delta)
    {

    }

    @Override
    public void draw(SpriteBatch batch)
    {

    }

}