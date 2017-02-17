
package com.linux.stw.util.factory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Json;
import com.linux.stw.character.*;
import com.linux.stw.character.hero.Defensive;
import com.linux.stw.character.hero.Equilibrate;
import com.linux.stw.character.hero.Hero;
import com.linux.stw.character.hero.Savage;
import com.linux.stw.util.CollisionManager;

/**
 * Created by nahum on 09/02/17.
 */
public class HeroFactory
{
    public static Hero createHero(HeroType type, int level)
    {
        Stats stats;

        switch(type)
        {
            case TUX:
                stats = new Equilibrate(); break;
            case GNU:
                stats = new Defensive(); break;
            case FOX:
                stats = new Savage(); break;
            default:
                throw new ExceptionInInitializerError("HeroFactory: This Hero doesnt exist");
        }

        Hero hero = new Hero(stats, new LinealExperience(stats, 1));

        hero.setName(type.toString().toLowerCase());
        hero.getExperience().levelUp(level-1);
        hero.setTexture(new Texture(Gdx.files.internal("data/hero/tux/0001.png")));
        hero.setRectangle(new Rectangle(hero.getPosition().x, hero.getPosition().y,
                hero.getTexture().getWidth(), hero.getTexture().getHeight()));

        hero.getPosition().set(hero.getPosition().x + hero.getTexture().getWidth()/2,
                hero.getPosition().y + hero.getTexture().getHeight()/2);

        CollisionManager.getInstance().addPlayable(hero);

        return hero;
    }

    public static Experience readExperienceFromJSON(String path, ExperienceType expType)
    {
        Json json = new Json();
        Experience experience = null;

        switch (expType) {
            case LINEAL:
                experience = json.fromJson(LinealExperience.class, Gdx.files.local(path));
                break;
            default:
                throw new ExceptionInInitializerError("HeroFactory: This Experience type doesnt exist");
        }

        return experience;
    }
}
