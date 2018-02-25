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
        double a = line[1][1] - line[0][1];
        double b = line[0][1] - line[1][0];
        double dist = distancePointLine(point, line);
        return new double[] {point[0] - a * dist, point[1] - b * dist};
    }

    public static double distancePointSegment(double[] point, double[][] segment) {
        double[] projectionPoint = projectionPointOnLine(point, segment);
        if (Math.abs(segment[0][Y] - segment[1][Y]) < 1e-4 || segment[0][Y] > point[Y] != segment[1][Y] > point[Y] &&
                Math.abs(segment[0][X] - segment[1][X]) < 1e-4 || segment[0][X] > point[X] != segment[1][X] > point[X]){
            return distancePointLine(point, segment);
        }
        return Double.POSITIVE_INFINITY;
    }

    public static double distancePointLine(double[] point, double[][] line) {
        double a = line[1][1] - line[0][1];
        double b = line[0][1] - line[1][0];
        double c = -a * line[0][0] - b * line[0][1];
        double normal = Math.sqrt(sqr(a) + sqr(b));
        return  (a * point[0] + b * point[1] + c) / normal;
    }

    public static double sqr(double x) {
        return x * x;
    }
}
