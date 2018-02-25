package ru.elonmusk.simulator.constructor.parts.shape;

public class Bound {
    public int[] start, end;

    public Bound(int startX, int startY, int endX, int endY) {
        start = new int[]{startX, startY};
        end = new int[]{endX, endY};
    }

    public Bound(double[][] points) {
        this((int) points[0][0],(int) points[0][1],(int) points[1][0],(int) points[1][1]);
    }

    public double angle(Bound bound) {
        return 0;
    }
}
