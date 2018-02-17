package ru.elonmusk.simulator;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.elonmusk.simulator.constructor.Constructor;
import ru.elonmusk.simulator.flight.Space;

public class Game implements Renderable {

    Space space;
    Controller controller;
    Constructor constructor;

    public Game() {
        space = new Space();
        controller = new Controller();
    }

    @Override
    public void render(SpriteBatch batch, double delta) {
        //Все что нужно отрендерить пишем в этот массив
        Renderable[] toRender = new Renderable[] {
                space,
                constructor,
        };
        for (Renderable renderable : toRender)
            renderable.render(batch, delta);
    }
}
