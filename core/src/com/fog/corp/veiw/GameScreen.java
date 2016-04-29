package com.fog.corp.veiw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.fog.corp.controller.PlayerController;
import com.fog.corp.model.GameWorld;

/**
 * Created by Izonami on 27.04.2016.
 */
public class GameScreen extends AbstractScreen
{
    private GameWorld world;
    private PlayerController controller; // Контроллер персонажа

    public GameScreen()
    {
        world = new GameWorld("MainScene");
        controller = new PlayerController(world); // Инициализируем контроллер
        setCamera((OrthographicCamera)world.getViewport().getCamera());
        getCamera().position.set(315, (world.getPlayer().getCenterY() + 150),0); //TODO: Костыль
    }

    @Override
    public void show()
    {
        super.show();

        Gdx.input.setInputProcessor(this); // Присваиваем инпут процессор
    }

    @Override
    public void render(float delta)
    {
        super.render(delta);

        world.getSceneLoader().getEngine().update(delta);

        setCameraPosition(world.getPlayer().getCenterX(), (world.getPlayer().getCenterY()+150));
        controller.update(delta);
    }

    // Слушатель нажатия
    @Override
    public boolean keyDown(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.RIGHT : controller.rightPressed();
                break;
            case Input.Keys.LEFT : controller.leftPressed();
                break;
            case Input.Keys.UP : controller.upPressed();
                break;
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        switch (keycode)
        {
            case Input.Keys.RIGHT : controller.rightReleased();
                break;
            case Input.Keys.LEFT : controller.leftReleased();
                break;
            case Input.Keys.UP : controller.upReleased();
                break;
        }

        return true;
    }
}
