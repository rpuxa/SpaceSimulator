package ru.elonmusk.simulator.flight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;

import java.util.ArrayList;

import ru.elonmusk.simulator.utils.GestureListener;

public class Space implements Screen{
    ArrayList<Body> bodies;
    private Stage stage;
    private SpriteBatch batch;

    public Space(SpriteBatch batch) {
        this.batch = batch;
        stage = new Stage(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), batch);

        Planet sun = new Planet(1989000e24, null, null, "earth");
        Planet[] planets = {
                new Planet(2.52e21, sun, new Trajectory(0.2, 5.0526e9, 0, 0.5), "earth"),
                new Planet(1.22e23, sun, new Trajectory(0.01, 9_832_684_544d, 0, 1), "bad"),
                new Planet(5.29e22, sun, new Trajectory(0.017, 13_599_840_256d, 0, 0), "bad")
        };

        for (Planet planet : planets){
            bodies.add(planet);
            stage.addActor(planet);
        }

        Gdx.input.setInputProcessor(stage);
        stage.getRoot().addListener(new GestureListener(new GestureListener.GestureExtendedAdapter(){
            @Override
            public boolean fling(float velocityX, float velocityY, int button) {
                //stage.getCamera().
                return false;
            }
            
        }));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
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

    }
}
