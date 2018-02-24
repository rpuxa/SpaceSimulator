package ru.elonmusk.simulator.flight;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.elonmusk.simulator.Assets;

public class Planet extends Body {

    double radius;
    TextureRegion texture;

    public Planet(double mass, Body centralBody, Trajectory trajectory, String textureName) {
        super(mass, centralBody);
        this.trajectory = trajectory;
        texture = Assets.getTexture(textureName);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(texture, (float) (getX() - radius), (float) (getY() - radius));
    }
}
