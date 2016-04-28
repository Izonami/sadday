package com.fog.corp.veiw;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.fog.corp.GameStart;
import com.fog.corp.controller.PlayerController;
import com.fog.corp.model.GameWorld;

/**
 * Created by Izonami on 27.04.2016.
 */
public class GameScreen extends AbstractScreen
{
    private GameWorld world;
    private PlayerController controller; // Контроллер персонажа
    private OrthographicCamera camera;

    public GameScreen(final GameStart app)
    {
        super(app);

        world = new GameWorld("MainScene");
        controller = new PlayerController(world); // Инициализируем контроллер
        camera = (OrthographicCamera)world.getViewport().getCamera();
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

        camera.position.x = world.getPlayer().getCenterX();
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
        }

        return true;
    }
}
