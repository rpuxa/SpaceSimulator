package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ru.elonmusk.simulator.Renderable;
import ru.elonmusk.simulator.constructor.parts.Part;


public class SpacecraftInfo implements Renderable {

    public Part mainPart;

    @Override
    public void render(SpriteBatch batch, double delta) {
        if (mainPart != null)
            mainPart.render(batch, delta);
    }
}
