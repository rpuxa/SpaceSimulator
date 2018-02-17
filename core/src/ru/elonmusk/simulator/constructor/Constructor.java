package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.elonmusk.simulator.Renderable;

public class Constructor implements Renderable{

    SpacecraftInfo info = new SpacecraftInfo();

    @Override
    public void render(SpriteBatch batch, double delta) {
        info.render(batch, delta);
    }
}
