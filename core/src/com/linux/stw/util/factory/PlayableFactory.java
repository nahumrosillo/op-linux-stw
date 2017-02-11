/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.linux.stw.util.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.SerializationException;
import com.linux.stw.character.*;

import static com.badlogic.gdx.Gdx.app;

/**
 * Created by nahum on 09/02/17.
 */
public class PlayableFactory
{
    public static com.linux.stw.character.player.Hero createHero(HeroType type, ExperienceType expType, int level) throws ExceptionInInitializerError
    {
        Stats stats;
        Experience experience;

        switch(type)
        {
            case TUX:
                stats = new com.linux.stw.character.player.Equilibrate(); break;
            case GNU:
                stats = new com.linux.stw.character.player.Defensive(); break;
            case FOX:
                stats = new com.linux.stw.character.player.Savage(); break;
            default:
                throw new ExceptionInInitializerError("PlayableFactory: This Hero doesnt exist");
        }

        switch(expType)
        {
            case LINEAL:
                experience = new LinealExperience(stats, level); break;
            default:
                throw new ExceptionInInitializerError("PlayableFactory: This Experience type doesnt exist");
        }

        return new com.linux.stw.character.player.Hero(stats, experience);
    }

    public static Playable createPlayableFromJSON(String path)
    {
        Json json = new Json();
        Playable player = null;

        try
        {
            player = json.fromJson(com.linux.stw.character.player.Hero.class, Gdx.files.local(path));
        }
        catch (SerializationException e)
        {
            app.log("ERROR", path + ".json. " + "File does not exist");
            e.printStackTrace();
        }

        return player;
    }
}
