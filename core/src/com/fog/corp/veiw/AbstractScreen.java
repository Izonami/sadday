package com.fog.corp.veiw;

import com.badlogic.gdx.Screen;
import com.fog.corp.GameStart;

/**
 * Created by Izonami on 27.04.2016.
 */
public abstract class AbstractScreen implements Screen
{
    private final GameStart app;

    public AbstractScreen(final GameStart app)
    {
        this.app = app;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public GameStart getApp()
    {
        return app;
    }
}
