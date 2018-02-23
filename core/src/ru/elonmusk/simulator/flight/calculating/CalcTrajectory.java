package ru.elonmusk.simulator.flight.calculating;

import ru.elonmusk.simulator.flight.Body;
import ru.elonmusk.simulator.flight.Trajectory;
import ru.elonmusk.simulator.utils.Constants;
import ru.elonmusk.simulator.utils.MathUtils;

public class CalcTrajectory implements Constants {

    public static Trajectory calculate(Body body) {
        double realAxis = body.radiusVector * body.getGravityParameter() / (2 * body.getGravityParameter() - MathUtils.sqr(body.getVelocityModule()) * body.radiusVector);
        double[][] points = calculatePoints(body);
        Function function = (alpha) -> {
            double c = Math.cos(points[0][ANGLE] + alpha);
            double e = (-c * points[0][RADIUS] + Math.sqrt(MathUtils.sqr(c * points[0][RADIUS]) - 4 * realAxis * (points[0][RADIUS] - realAxis))) / (2 * realAxis);
            return (realAxis * (1 - MathUtils.sqr(e)) / (1 + e * Math.cos(points[1][ANGLE] + alpha))) - points[1][RADIUS];
        };

        double angle = foundRoot(function, 0 ,3);
        double c = Math.cos(points[0][ANGLE] + angle);
        double e = (-c * points[0][RADIUS] + Math.sqrt(MathUtils.sqr(c * points[0][RADIUS]) - 4 * realAxis * (points[0][RADIUS] - realAxis))) / (2 * realAxis);
        return new Trajectory(e, realAxis, angle, body.angle);
    }

    private static double[][] calculatePoints(Body body0) {
        Body body = new Body(body0);
        final double tau = .01;
        for (int i = 0; i < 100; i++) {
            double a = GRAVITATIONAL_CONSTANT * body.centralBody.mass / MathUtils.sqr(body.radiusVector);
            double[] acceleration = {Math.cos(body.angle) * a, Math.sin(body.angle) * a};
            body.velocity[X] += acceleration[X] * tau;
            body.velocity[Y] += acceleration[Y] * tau;
            body.x += body.velocity[X] * tau;
            body.y += body.velocity[Y] * tau;
        }
        return new double[][] {
                {
                        body0.radiusVector, body0.angle
                },
                {
                        MathUtils.moduleOfVector(body.x - body.centralBody.x, body.y - body.centralBody.y),
                        Math.atan2(body.y - body.centralBody.y, body.x - body.centralBody.x)
                }
        };
    }

    private static double foundRoot(Function function, double from, double maxOrder) {
        int order = 0;
        double step = 10;
        boolean lastSign = function.invoke(from) > 0;
        for (double arg = from + step; true; arg += step) {
            if (lastSign != function.invoke(arg) > 0){
                step /= -10;
                if (order ++>= maxOrder)
                    return arg;
            }
        }
    }

    private interface Function {
        double invoke(double arg);
    }
}
