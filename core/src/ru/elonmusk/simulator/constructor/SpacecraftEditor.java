package ru.elonmusk.simulator.constructor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Group;

import ru.elonmusk.simulator.constructor.parts.Models;
import ru.elonmusk.simulator.constructor.parts.Part;
import ru.elonmusk.simulator.utils.GestureListener;

public class SpacecraftEditor extends Group {

    public SpacecraftEditor() {
        setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        addListener(new GestureListener(getInput()));
    }

    private GestureListener.GestureExtendedAdapter getInput() {
        return new GestureListener.GestureExtendedAdapter() {
            @Override
            public boolean pan(float x, float y, float deltaX, float deltaY) {
                Part main = getMainPart();
                main.setPosition(main.getX() + deltaX, main.getY() + deltaY);
                return false;
            }

            @Override
            public boolean tap(float x, float y, int count, int button) {
                setMainPath(new Part(Models.FL100));
                return false;
            }
        };
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    public void setMainPath(Part part) {
        clearChildren();
        addActor(part);
    }

    public Part getMainPart() {
        return (Part) getChildren().get(0);
    }
}
