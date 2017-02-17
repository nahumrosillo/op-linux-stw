package com.linux.stw.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthoCachedTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by nahum on 13/02/17.
 */
public class TileMapManager
{
    private TiledMap map;
    private TmxMapLoader loader;
    private OrthogonalTiledMapRenderer renderer;
    private Vector2 direction;

    public TileMapManager(String path)
    {
        map = new TiledMap();

        loader = new TmxMapLoader();
        map = loader.load(path);
        renderer = new OrthogonalTiledMapRenderer(map);
        direction = new Vector2();

        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);

        Constants.HEIGHT_LEVEL = layer.getHeight() * layer.getTileHeight();
        Constants.WIDTH_LEVEL = layer.getWidth() * layer.getTileWidth();

    }

    public void update(float delta, OrthographicCamera camera, Viewport viewport)
    {
        if ((camera.position.y + camera.viewportHeight*0.5f) < Constants.HEIGHT_LEVEL)
        {
            camera.position.y += Constants.SPEED_CAMERA * delta;
        }

        TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(0);

        float cameraMinX = viewport.getWorldWidth() * 0.5f;
        float cameraMinY = viewport.getWorldHeight() * 0.5f;

        float cameraMaxX = layer.getWidth() * layer.getTileWidth() - cameraMinX;
        float cameraMaxY = layer.getHeight() * layer.getTileHeight() - cameraMinY;

        camera.position.x = MathUtils.clamp(camera.position.x, cameraMinX, cameraMaxX);
        camera.position.y = MathUtils.clamp(camera.position.y, cameraMinY, cameraMaxY);

        camera.update();
        renderer.setView(camera);
        renderer.render();
    }
}
