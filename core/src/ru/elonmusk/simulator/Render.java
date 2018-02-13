package ru.elonmusk.simulator;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Render extends ApplicationAdapter {

	SpriteBatch batch;
	Game game;
	OrthographicCamera camera;

	
	@Override
	public void create () {
		game = new Game();
		Gdx.input.setInputProcessor(getProcessor());
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		game.render(batch, Gdx.graphics.getDeltaTime());
		batch.end();
	}
	
	@Override
	public void dispose () {

	}

	private InputProcessor getProcessor() {
		return new InputProcessor() {
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
				game.controller.touchDown(screenX, screenY, pointer, button);
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				game.controller.touchUp(screenX, screenY, pointer, button);
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				game.controller.touchDragged(screenX, screenY, pointer);
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
			    game.controller.scrolled(amount);
				return false;
			}
		};
	}
}
