package com.linux.stw.util.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Json;
import com.linux.stw.character.Experience;
import com.linux.stw.character.LinealExperience;
import com.linux.stw.character.Playable;
import com.linux.stw.character.Stats;
import com.linux.stw.character.enemy.Mutant;
import com.linux.stw.util.CollisionManager;

/**
 * Created by nahum on 11/02/17.
 */
public class MutantFactory
{
    public static Playable createMutant(MutantType name, int level)
    {
        Playable mutant;
        Json json = new Json();
        String path = "data/enemy/" + name.toString().toLowerCase() + "/";

        Experience exp = json.fromJson(LinealExperience.class, Gdx.files.internal(path + "exp.json"));
        Stats stats = exp.getStats();

        switch(name)
        {
            case TOMATO:
                mutant = new Mutant(stats, exp); break;
            default:
                mutant = null;
        }

        mutant.setName(name.toString().toLowerCase());
        mutant.getExperience().levelUp(level-1);
        mutant.setTexture(new Texture(Gdx.files.internal(path + name.toString().toLowerCase() + ".png")));
        mutant.setRectangle(new Rectangle(mutant.getPosition().x, mutant.getPosition().y,
                mutant.getTexture().getWidth(), mutant.getTexture().getHeight()));

        CollisionManager.getInstance().addPlayable(mutant);

        return mutant;
    }
}
