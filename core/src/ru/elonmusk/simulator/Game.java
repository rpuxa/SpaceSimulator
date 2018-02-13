package ru.elonmusk.simulator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.elonmusk.simulator.flight.Space;

public class Game implements Renderable {

    Space space;
    Controller controller;

    public Game() {
        space = new Space();
        controller = new Controller();
    }

    @Override
    public void render(SpriteBatch batch, double delta) {
        space.render(batch, delta);
    }
}
