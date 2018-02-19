package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;

import ru.elonmusk.simulator.constructor.parts.Part;

public class SpacecraftEditor extends Group {

    public SpacecraftEditor() {
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    public void setMainPath(Part part) {
        clearChildren();
        addActor(part);
    }
}
