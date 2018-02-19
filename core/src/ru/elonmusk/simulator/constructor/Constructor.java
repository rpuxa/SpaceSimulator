package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;


public class Constructor implements Screen {

    private SpriteBatch batch;
    private Stage stage;
    public SpacecraftEditor spacecraftEditor;

    public Constructor(SpriteBatch batch) {
        this.batch = batch;
        stage = new Stage(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        spacecraftEditor = new SpacecraftEditor();
        stage.addActor(spacecraftEditor);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        batch.begin();
        spacecraftEditor.draw(batch, 1);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(getProcessor());
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
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
        };

    }
}
