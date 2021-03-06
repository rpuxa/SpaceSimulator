package ru.elonmusk.simulator.constructor.parts;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.elonmusk.simulator.constructor.parts.shape.Shape;

//Тип детали корабля
public class TypePart {
    String texturePath;
    public Shape shape;
    int width, height;

    public TypePart(String texturePath, Shape shape, int width, int height) {
        this.texturePath = texturePath;
        this.shape = shape;
        this.width = width;
        this.height = height;
    }
}
