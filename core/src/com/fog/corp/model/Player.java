package com.fog.corp.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Izonami on 28.04.2016.
 */
public class Player implements IScript
{
    private Vector2 speed;
    private float gravity       = -300f;
    private float jumpSpeed     = 200f;
    public boolean jump         = false;

    Entity entity;
    public TransformComponent transformComponent;
    private DimensionsComponent dimensionsComponent;

    @Override
    public void init(Entity entity)
    {
        this.entity = entity;

        transformComponent = ComponentRetriever.get(entity, TransformComponent.class);
        dimensionsComponent = ComponentRetriever.get(entity, DimensionsComponent.class);
        transformComponent.originX = dimensionsComponent.width/2;
        transformComponent.originY = dimensionsComponent.height/2;

        speed = new Vector2(100, 0);
    }

    @Override
    public void act(float delta)
    {
        speed.y += gravity*delta;
        transformComponent.y += speed.y*delta;

        if(transformComponent.y < 55f)
        {
            speed.y = 0;
            transformComponent.y = 55f;
        }
    }

    @Override
    public void dispose() {

    }

    public TransformComponent getTC()
    {
        return transformComponent;
    }

    public void changeScale(float scale)
    {
        transformComponent.scaleX = scale;
    }

    public float getCenterX()
    {
        return transformComponent.x+dimensionsComponent.width/2;
    }

    public float getCenterY()
    {
        return transformComponent.y+dimensionsComponent.height/2;
    }

    public Vector2 getSpeed()
    {
        return speed;
    }

    public float getJumpSpeed()
    {
        return jumpSpeed;
    }

    public boolean isJump()
    {
        return jump;
    }
}
