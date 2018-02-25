package ru.elonmusk.simulator;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.elonmusk.simulator.constructor.Constructor;
import ru.elonmusk.simulator.flight.Space;

public final class SpaceSimulator extends com.badlogic.gdx.Game {

    public static SpaceSimulator instance;

    SpriteBatch batch;
    OrthographicCamera camera;

    Space space;
    Constructor constructor;

    @Override
    public void create() {
        Assets.load();
        instance = this;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        batch.setProjectionMatrix(camera.combined);
        space = new Space(batch);
        constructor = new Constructor(batch);
        setScreen(constructor);
       // setScreen(space);
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
