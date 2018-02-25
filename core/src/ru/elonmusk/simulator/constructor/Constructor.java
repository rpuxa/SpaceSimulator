package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import ru.elonmusk.simulator.utils.GestureListener;


public class Constructor implements Screen {

    private SpriteBatch batch;
    private Stage stage;
    public SpacecraftEditor spacecraftEditor;

    public Constructor(SpriteBatch batch) {
        this.batch = batch;
        stage = new Stage(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);
        spacecraftEditor = new SpacecraftEditor();
        stage.addActor(spacecraftEditor);
        Gdx.input.setInputProcessor(stage);
        stage.setKeyboardFocus(spacecraftEditor);
        stage.getRoot().addListener(new GestureListener());
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        stage.draw();
        stage.act(delta);
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
        batch.dispose();
    }
}
