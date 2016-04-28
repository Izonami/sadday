package com.fog.corp.model;

import com.badlogic.ashley.core.Entity;
import com.uwsoft.editor.renderer.scripts.IScript;

/**
 * Created by Izonami on 28.04.2016.
 */
public class Cloud implements IScript
{
    Entity entity;

    @Override
    public void init(Entity entity)
    {
        this.entity = entity;
    }

    @Override
    public void act(float delta) {

    }

    @Override
    public void dispose() {

    }
}
