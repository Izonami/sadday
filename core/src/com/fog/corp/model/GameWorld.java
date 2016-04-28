package com.fog.corp.model;

import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.utils.ItemWrapper;

/**
 * Created by Izonami on 28.04.2016.
 */
public class GameWorld
{
    private Player player; // Игрок
    private SceneLoader sceneLoader; //Сцена
    private Viewport viewport;
    private ItemWrapper rootItem;

    public GameWorld(String name)
    {
        viewport = new StretchViewport(640, 480);
        sceneLoader = new SceneLoader();
        sceneLoader.loadScene(name, viewport);

        player = new Player();

        rootItem = new ItemWrapper(sceneLoader.getRoot());
        rootItem.getChild("sheepGerl").addScript(player);
    }

    public Viewport getViewport()
    {
        return viewport;
    }

    public SceneLoader getSceneLoader()
    {
        return sceneLoader;
    }

    // Возвращает созданного игрока
    public Player getPlayer()
    {
        return player;
    }
}
