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
        //Gdx.input.setInputProcessor(getProcessor());
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }


}
