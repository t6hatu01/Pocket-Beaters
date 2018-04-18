package fighting.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fighting.game.Screens.PlayScreen;


public class FightingGame extends Game {
	public static final int V_WIDTH = 1920;
	public static final int V_HEIGHT = 1080;
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
