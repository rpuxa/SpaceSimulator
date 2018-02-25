package ru.elonmusk.simulator.constructor.parts;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.ArrayList;

import ru.elonmusk.simulator.Assets;
import ru.elonmusk.simulator.constructor.SpacecraftEditor;
import ru.elonmusk.simulator.constructor.TouchableGroup;
import ru.elonmusk.simulator.constructor.parts.shape.Bound;
import ru.elonmusk.simulator.utils.Constants;
import ru.elonmusk.simulator.utils.MathUtils;

public class Part extends TouchableGroup implements Constants {
    TypePart type;
    TextureRegion texture;
    SpacecraftEditor editor;
    boolean dragging;

    public Part(TypePart type, SpacecraftEditor editor) {
        this.editor = editor;
        this.type = type;
        setSize(type.width, type.height);
        texture = Assets.getTexture(type.texturePath);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (dragging) {
            double[] cling = cling();
            if (cling != null) {
                batch.draw(texture, (float) cling[0], (float) cling[1], (float) cling[2], (float) cling[3], getWidth(), getHeight(), getScaleX(), getScaleY(), (float) cling[4]);
                return;
            }
        }
        batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    private double[] cling() {
        ArrayList<Part> parts = editor.getAllParts(this);
        for (Part part : parts) {
            double[][] shift = shift(part);
            if (shift != null) {
                return new double[] {shift[0][0], shift[0][1], shift[1][0], shift[1][1], shift[2][0]};
            }
        }
        return null;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        dragging = true;
        return true;
    }

    @Override
    public boolean touchUp(float x, float y, int pointer, int button) {
        dragging = false;
        return true;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        setPosition(getX() + deltaX, getY() + deltaY);
        return true;
    }

    /**
    @return {shiftX, shitY}, {OriginX, OriginY}, {ShiftAngle}
     */
    public double[][] shift(Part part) {
        double min = 100;
        boolean shifted = false;
        double[][] shift = {{0, 0}, {0, 0}, {0}};
        for (Bound firstBounds : type.shape.bounds)
            for (Bound secondBound : part.type.shape.bounds) {
                double[][] first = getBoundCoords(firstBounds),
                        second = part.getBoundCoords(secondBound);
                double angle = Math.abs(Math.atan2(first[0][Y] - first[1][Y], first[0][X] - first[1][X]) -
                        Math.atan2(second[0][Y] - second[1][Y], second[0][X] - second[1][X]));
                if (angle > Math.toRadians(170) && angle < Math.toRadians(190))
                    for (int i = 0; i < 2; i++) {
                        double result = MathUtils.distancePointSegment(first[i], second);
                        if (result < min) {
                            shifted = true;
                            min = result;
                            double[] projection = MathUtils.projectionPointOnLine(first[i], second);
                            shift[0][0] = projection[0] - first[i][0];
                            shift[0][1] = projection[1] - first[i][1];
                            shift[1][0] = -angle;
                        }
                    }
            }
        if (shifted)
            return shift;
        else
            return null;
    }

    private double[][] getBoundCoords(Bound bound) {
        return new double[][] {
                MathUtils.rotatePoint(new double[]{bound.start[0] * getWidth() + getX(), bound.start[1] * getHeight() + getY()}, new double[]{getOriginX(), getOriginY()}, getRotation()),
                MathUtils.rotatePoint(new double[]{bound.end[0] * getWidth() + getX(), bound.end[1] * getHeight() + getY()}, new double[]{getOriginX(), getOriginY()}, getRotation()),
        };
    }

    public ArrayList<Part> getAllParts(Part without) {
        ArrayList<Part> parts = new ArrayList<>();
        if (equals(without))
            return parts;
        parts.add(this);
        for (Actor part : getChildren()) {
                parts.addAll(((Part) part).getAllParts(without));
        }
        return parts;
    }

    public boolean equals(Part part) {
        return part.getX() == getX() && part.getY() == getY();
    }
}
