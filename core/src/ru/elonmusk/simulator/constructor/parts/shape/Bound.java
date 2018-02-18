package ru.elonmusk.simulator.constructor.parts.shape;

public class Bound {
    public int[] start, end;

    public Bound(int startX, int startY, int endX, int endY) {
        start = new int[]{startX, startY};
        end = new int[]{endX, endY};
    }
}
