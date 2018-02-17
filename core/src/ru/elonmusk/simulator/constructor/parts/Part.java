package ru.elonmusk.simulator.constructor.parts;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;

import ru.elonmusk.simulator.Renderable;

public class Part implements Renderable {
    TypePart type;
    TextureRegion texture;
    int x, y;
    ArrayList<Part>[] child;
    Part parent;

    public Part(TypePart type, Part parent) {
        this.type = type;
        child = new ArrayList[type.bounds.length];
        this.parent = parent;
        texture = new TextureRegion(new Texture(type.texturePath));
    }

    @Override
    public void render(SpriteBatch batch, double delta) {
        batch.draw(texture, x - type.width / 2, y - type.height / 2);
    }
}
