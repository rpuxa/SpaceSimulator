package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

import ru.elonmusk.simulator.Assets;
import ru.elonmusk.simulator.constructor.parts.Models;
import ru.elonmusk.simulator.constructor.parts.Part;

public class SpacecraftEditor extends TouchableGroup {
    TextureRegion back;


    public SpacecraftEditor() {
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        back = Assets.getTexture("cBack");
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        setPosition(getX() + deltaX, getY() + deltaY);
        return true;
    }

    @Override
    public void keyDown(int keycode) {
        addActor(new Part(Models.FL100, this));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(back, getX(), getY(), getWidth(), getHeight());
        super.draw(batch, parentAlpha);
    }

    public void setMainPath(Part part) {
        clearChildren();
        addActor(part);
    }

    public Part getMainPart() {
        if (getChildren().size == 0)
            return null;
        else
            return (Part) getChildren().get(0);
    }

    public ArrayList<Part> getAllParts(Part without) {
        return getMainPart().getAllParts(without);
    }

    public void removePart(Part part) {
        getMainPart().removePart(part);
    }

}
