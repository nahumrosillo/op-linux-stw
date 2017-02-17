/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.character.hero;

import com.linux.stw.character.Stats;

/**
 * Created by nahum on 08/02/17.
 */
public class Equilibrate extends Stats
{

    public Equilibrate()
    {
        super();

        life = LIFE_BASE;
        hp = HP_BASE;
        str = STR_BASE;
        def = DEF_BASE;
        spd_attack = SPD_ATTACK_BASE;
    }
}
