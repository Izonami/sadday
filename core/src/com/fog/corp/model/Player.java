package com.fog.corp.model;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.uwsoft.editor.renderer.components.DimensionsComponent;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.components.physics.PhysicsBodyComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Izonami on 28.04.2016.
 */
public class Player implements IScript
{
    public static final float SPEED = 3f; //Скорость персонажа
    private Vector2 velocity    = new Vector2();
    private float jumpImpulse     = 100f;
    public boolean isJump       = false;

    Entity entity;
    private TransformComponent tc;
    private DimensionsComponent dc;
    private PhysicsBodyComponent pbc;

    @Override
    public void init(Entity entity)
    {
        this.entity = entity;

        tc = ComponentRetriever.get(entity, TransformComponent.class);
        dc = ComponentRetriever.get(entity, DimensionsComponent.class);
        pbc = ComponentRetriever.get(entity, PhysicsBodyComponent.class);
    }

    @Override
    public void act(float delta)
    {
        velocity.y = pbc.body.getLinearVelocity().y;
        pbc.body.setLinearVelocity(velocity);
        pbc.body.setFixedRotation(true);

        if(isJump)
        {
            pbc.body.applyLinearImpulse(0, jumpImpulse, pbc.body.getPosition().x, pbc.body.getPosition().y, true);
            isJump = false;
        }
    }

    @Override
    public void dispose()
    {

    }

    public void changeScale(float scale)
    {
        tc.scaleX = scale;
    }

    public float getCenterX()
    {
        return tc.x+dc.width/2;
    }

    public float getCenterY()
    {
        return tc.y+dc.height/2;
    }

    public Vector2 getVelocity()
    {
        return velocity;
    }

    public void resetVelocity()
    {
        velocity.x = 0;
        velocity.y = 0;
    }

    public void jump()
    {
        isJump = true;
    }
}
