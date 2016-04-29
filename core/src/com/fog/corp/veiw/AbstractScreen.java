package com.fog.corp.veiw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import static com.fog.corp.utils.Constants.LOG;

/**
 * Created by Izonami on 27.04.2016.
 */
public abstract class AbstractScreen implements Screen, InputProcessor
{
    private final Color clear = new Color(0f,0f,0f,0f);
    private Camera cam; //Камера

    @Override
    public void show()
    {
        Gdx.app.log(LOG, "Showing screen: " + getName());
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(clear.a,clear.b,clear.g,clear.r);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Очистка экрана
    }

    @Override
    public void resize(int width, int height)
    {
        Gdx.app.log(LOG, "Resizing screen: " + getName() + " to: " + width + " x " + height);
    }

    @Override
    public void pause()
    {
        Gdx.app.log(LOG, "Pausing screen: " + getName());
    }

    @Override
    public void resume()
    {
        Gdx.app.log(LOG, "Resuming screen: " + getName());
    }

    @Override
    public void hide()
    {
        Gdx.app.log(LOG, "Hiding screen: " + getName());

        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose()
    {
        Gdx.app.log(LOG, "Disposing screen: " + getName());
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    // Создаем камеру
    public void setCamera(OrthographicCamera cam)
    {
        this.cam = cam;
    }

    // Указываем позицию камеры и обновляем её
    public void setCameraPosition(float x, float y)
    {
        //TODO: Убрать костыли и сделать проверку по какому нибудь объекту, который должен обязательно быть на сцене
        if(x >= 790 || x <= 314)
        {
            return;
        }
        
        getCamera().position.set(x, y, 0);
    }

    // Возвращаем созданную камеру
    public Camera getCamera()
    {
        return cam;
    }

    protected String getName()
    {
        return getClass().getSimpleName();
    }
}
