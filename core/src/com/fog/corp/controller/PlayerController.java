package com.fog.corp.controller;

import com.fog.corp.model.GameWorld;
import com.fog.corp.model.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Izonami on 28.04.2016.
 */
public class PlayerController
{
    private GameWorld world;

    enum Keys
    {
        LEFT, RIGHT, UP, DOWN
    }

    static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();

    static
    {
        keys.put(Keys.LEFT, false);
        keys.put(Keys.RIGHT, false);
        keys.put(Keys.UP, false);
        keys.put(Keys.DOWN, false);
    }

    public PlayerController(GameWorld world)
    {
        this.world = world;
    }

    public void leftPressed()
    {
        keys.get(keys.put(Keys.LEFT, true));
    }

    public void rightPressed()
    {
        keys.get(keys.put(Keys.RIGHT, true));
    }

    public void upPressed()
    {
        keys.get(keys.put(Keys.UP, true));
    }

    public void downPressed()
    {
        keys.get(keys.put(Keys.DOWN, true));
    }

    public void leftReleased()
    {
        keys.get(keys.put(Keys.LEFT, false));
    }

    public void rightReleased()
    {
        keys.get(keys.put(Keys.RIGHT, false));
    }

    public void upReleased()
    {
        keys.get(keys.put(Keys.UP, false));
    }

    public void downReleased()
    {
        keys.get(keys.put(Keys.DOWN, false));
    }

    public void update(float delta)
    {
        processInput(delta);
    }

    public void resetWay()
    {
        rightReleased();
        leftReleased();
        downReleased();
        upReleased();
    }

    private void processInput(float delta)
    {
        if(keys.get(Keys.LEFT))
        {
            world.getPlayer().transformComponent.x -= Player.SPEED*delta;
            world.getPlayer().changeScale(-1f);
        }

        if(keys.get(Keys.RIGHT))
        {
            world.getPlayer().transformComponent.x += Player.SPEED*delta;
            world.getPlayer().changeScale(1f);
        }

        /*world.getPlayer().resetVelocity();

        if (keys.get(Keys.LEFT))
            world.getPlayer().getVelocity().x =- Player.SPEED;

        if (keys.get(Keys.RIGHT))
            world.getPlayer().getVelocity().x = Player.SPEED;

        if (keys.get(Keys.UP))
            if(world.getPcl().isPlayerOnGround())
                world.getPlayer().jump();

        if (keys.get(Keys.DOWN))
            System.out.println("DOWN");

        if ((keys.get(Keys.UP) && keys.get(Keys.DOWN)) ||
                (!keys.get(Keys.UP) && (!keys.get(Keys.DOWN))))
            world.getPlayer().getVelocity().y = 0;

        if ((keys.get(Keys.LEFT) && keys.get(Keys.RIGHT)) ||
                (!keys.get(Keys.LEFT) && (!keys.get(Keys.RIGHT))))
            world.getPlayer().getVelocity().x = 0;*/
    }

}
