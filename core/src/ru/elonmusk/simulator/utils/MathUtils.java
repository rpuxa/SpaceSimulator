package ru.elonmusk.simulator.utils;

public final class MathUtils {

    private MathUtils() {

    }

    public static double moduleOfVector(double... vector) {
        return Math.sqrt(sqr(vector[0]) + sqr(vector[1]));
    }

    public static double sqr(double x) {
        return x * x;
    }
}
