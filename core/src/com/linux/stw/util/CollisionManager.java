package com.linux.stw.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.linux.stw.character.Playable;

/**
 * Created by nahum on 13/02/17.
 */
public class CollisionManager
{
    private static CollisionManager ourInstance = new CollisionManager();

    private QuadTree quadTree;
    private Array<Playable> playableArray;
    private Playable player;
    private Array<Rectangle> list;

    public static CollisionManager getInstance()
    {
        return ourInstance;
    }

    private CollisionManager()
    {
        quadTree = new QuadTree(0, new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        list = new Array<Rectangle>();
        playableArray = new Array<Playable>();
    }

    public void add(Rectangle rect)
    {
        quadTree.insert(rect);
    }

    public void addPlayable(Playable playable)
    {
        playableArray.add(playable);
    }

    public void setPlayer(Playable player) { this.player = player;}

    public void update()
    {
        for (Playable p : playableArray)
        {
            quadTree.retrieve(list, new Rectangle(p.getRectangle()));

            for (Rectangle r : list)
            {
                if (Intersector.overlaps(p.getRectangle(), r))
                {

                }
            }
        }

        quadTree.retrieve(list, new Rectangle(player.getRectangle()));

        for(Rectangle r : list)
        {
            if (Intersector.overlaps(player.getRectangle(), r))
            {

            }
        }
    }

    public void clear()
    {
        quadTree.clear();
        playableArray.clear();
    }
}
