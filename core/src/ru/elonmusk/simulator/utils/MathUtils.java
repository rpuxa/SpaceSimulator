package ru.elonmusk.simulator.utils;

public final class MathUtils implements Constants {

    private MathUtils() {

    }

    public static double moduleOfVector(double... vector) {
        return Math.sqrt(sqr(vector[0]) + sqr(vector[1]));
    }

    public static double distance(double[] first, double[] second) {
        return moduleOfVector(first[0] - second[0], first[1] - second[1]);
    }

    public static double[] rotatePoint(double[] point, double[] around, double angle) {
        double[] newPoint = {point[0] - around[0], point[1] - around[1]};
        double x = newPoint[0] * Math.cos(angle) - newPoint[1] * Math.sin(angle),
                y = newPoint[0] * Math.sin(angle) + newPoint[1] * Math.cos(angle);
        return new double[]{x + around[0], y + around[1]};
    }

    public static double[] projectionPointOnLine(double[] point, double[][] line) {
        double a = line[1][Y] - line[0][Y];
        double b = line[0][X] - line[1][X];
        double dist = distancePointLine(point, line);
        double angle = Math.atan2(a, b) + Math.PI / 2;
        return new double[] {point[0] + dist * Math.cos(angle), point[1] - dist * Math.sin(angle)};
    }

    public static void main(String[] args) {
        double[] d = projectionPointOnLine(new double[] {152, 90}, new double[][]{
                {137, 400},
                {137, 407}
        });
        System.out.println();
    }

    public static double distancePointSegment(double[] point, double[][] segment) {
        double[] projectionPoint = projectionPointOnLine(point, segment);
        if ((Math.abs(segment[0][Y] - segment[1][Y]) < 1e-4 || segment[0][Y] >= projectionPoint[Y] != segment[1][Y] > projectionPoint[Y]) &&
                (Math.abs(segment[0][X] - segment[1][X]) < 1e-4 || segment[0][X] >= projectionPoint[X] != segment[1][X] > projectionPoint[X])) {
            return distancePointLine(point, segment);
        }
        return Double.POSITIVE_INFINITY;
    }

    public static double distancePointLine(double[] point, double[][] line) {
        double a = line[1][Y] - line[0][Y];
        double b = line[0][X] - line[1][X];
        double c = -a * line[0][X] - b * line[0][Y];
        double normal = Math.sqrt(sqr(a) + sqr(b));
        return  (a * point[0] + b * point[1] + c) / normal;
    }

    public static double sqr(double x) {
        return x * x;
    }
}
