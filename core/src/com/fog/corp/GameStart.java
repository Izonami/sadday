package com.fog.corp;

import com.badlogic.gdx.Game;
import com.fog.corp.veiw.GameScreen;

public class GameStart extends Game
{
	@Override
	public void create ()
    {
        setScreen(new GameScreen());
	}

	@Override
	public void render ()
    {
		super.render();
	}

    @Override
    public void dispose()
    {
        super.dispose();

    }
}
