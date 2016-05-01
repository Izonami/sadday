package com.fog.corp.model;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.fog.corp.controller.PlayerContactListener;
import com.uwsoft.editor.renderer.SceneLoader;
import com.uwsoft.editor.renderer.components.physics.PhysicsBodyComponent;
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
    private PhysicsBodyComponent pbc;
    private PlayerContactListener pcl; // Слушатель соприкосновений

    public GameWorld(String name)
    {
        viewport = new FitViewport(640, 480);
        sceneLoader = new SceneLoader();
        sceneLoader.loadScene(name, viewport);
        pcl = new PlayerContactListener();
        sceneLoader.world.setContactListener(pcl);

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

    // Возвращает слушатель соприкосновений
    public PlayerContactListener getPcl()
    {
        return pcl;
    }
}
