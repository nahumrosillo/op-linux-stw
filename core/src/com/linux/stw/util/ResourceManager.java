package com.linux.stw.util;

import com.badlogic.gdx.assets.AssetManager;

/**
 * Created by nahum on 13/02/17.
 */
public class ResourceManager
{
    private static ResourceManager ourInstance = new ResourceManager();

    private AssetManager assetManager;

    public static ResourceManager getInstance() {
        return ourInstance;
    }

    private ResourceManager()
    {
        assetManager = new AssetManager();
    }
}
