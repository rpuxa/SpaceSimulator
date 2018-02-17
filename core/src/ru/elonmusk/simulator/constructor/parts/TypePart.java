package ru.elonmusk.simulator.constructor.parts;

//Тип детали корабля
public class TypePart {
    String texturePath;
    Bound[] bounds;
    int width, height;

    public TypePart(String texturePath, Bound[] bounds) {
        this.texturePath = texturePath;
        this.bounds = bounds;
    }
}
