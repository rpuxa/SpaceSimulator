package ru.elonmusk.simulator.flight;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.elonmusk.simulator.Renderable;

public class Body implements Renderable {

    double mass;
    double[] velocity;

    public Body(double mass, double[] velocity) {
        this.mass = mass;
        this.velocity = velocity;
    }

    @Override
    public void render(SpriteBatch batch, double delta){

    }

}