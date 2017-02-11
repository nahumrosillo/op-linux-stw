/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.character.player;

import com.linux.stw.character.Stats;

/**
 * Created by nahum on 08/02/17.
 */
public class Defensive extends Stats
{
    public Defensive()
    {
        super();

        life = LIFE_BASE;
        hp = (HP_BASE + (int) (HP_BASE * 0.25f));
        str = STR_BASE;
        def = (int) (DEF_BASE * 1.50f);
        spd_attack = SPD_ATTACK_BASE * 0.75f;
    }
}