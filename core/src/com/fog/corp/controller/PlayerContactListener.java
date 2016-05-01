package com.fog.corp.controller;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.*;
import com.uwsoft.editor.renderer.components.MainItemComponent;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;

/**
 * Created by Izonami on 01.05.2016.
 */
public class PlayerContactListener implements ContactListener
{
    private boolean isGround;

    @Override
    public void beginContact(Contact contact)
    {
        Entity entityA = (Entity) contact.getFixtureA().getBody().getUserData();
        Entity entityB = (Entity) contact.getFixtureB().getBody().getUserData();

        MainItemComponent itemA = ComponentRetriever.get(entityA, MainItemComponent.class);
        MainItemComponent itemB = ComponentRetriever.get(entityB, MainItemComponent.class);

        if(itemA.itemIdentifier != null && itemA.itemIdentifier.equals("sheepGerl"))
        {
            isGround = true;
        }

        if(itemB.itemIdentifier != null && itemB.itemIdentifier.equals("sheepGerl"))
        {
            isGround = true;
        }
    }

    @Override
    public void endContact(Contact contact)
    {
        Entity entityA = (Entity) contact.getFixtureA().getBody().getUserData();
        Entity entityB = (Entity) contact.getFixtureB().getBody().getUserData();

        MainItemComponent itemA = ComponentRetriever.get(entityA, MainItemComponent.class);
        MainItemComponent itemB = ComponentRetriever.get(entityB, MainItemComponent.class);

        if(itemA.itemIdentifier != null && itemA.itemIdentifier.equals("sheepGerl"))
        {
            isGround = false;
        }

        if(itemB.itemIdentifier != null && itemB.itemIdentifier.equals("sheepGerl"))
        {
            isGround = false;
        }
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    public boolean isPlayerOnGround()
    {
        return isGround;
    }
}
