package com.fog.corp.model;

import com.badlogic.ashley.core.Entity;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Izonami on 28.04.2016.
 */
public class Player implements IScript
{
    public static float SPEED = 100f;

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
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void dispose() {

    }

    public void changeScale(float scale)
    {
        transformComponent.scaleX = scale;
    }

    public float getCenterX() {
        return transformComponent.x+dimensionsComponent.width/2;
    }
    public float getCenterY() {
        return transformComponent.y+dimensionsComponent.height/2;
    }
}
