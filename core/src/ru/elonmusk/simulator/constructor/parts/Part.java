package ru.elonmusk.simulator.constructor.parts;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;

public class Part extends Group {
    TypePart type;
    TextureRegion texture;

    public Part(TypePart type) {
        this.type = type;
        texture = new TextureRegion(new Texture(type.texturePath));
        setSize(type.width, type.height);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }
}
