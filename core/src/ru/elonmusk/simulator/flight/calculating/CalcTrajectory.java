package ru.elonmusk.simulator.flight.calculating;

import ru.elonmusk.simulator.flight.Body;
import ru.elonmusk.simulator.flight.Trajectory;
import ru.elonmusk.simulator.utils.Constants;
import ru.elonmusk.simulator.utils.MathUtils;

public final class CalcTrajectory implements Constants {

   /* public static void main(String[] args) {
        Body body = new Body(1, new Body(1e20, null));
        body.radiusVector = 1000;
        body.x = 1000;
        body.velocity[Y] = 2583.3791*Math.sqrt(2);
        Trajectory trajectory = calculate(body);
        System.out.println();
    }*/

    public static Trajectory calculate(Body body) {
        double[][] points = calculatePoints(body, 3);
        double r1 = points[0][RADIUS], r2 = points[1][RADIUS], r3 = points[2][RADIUS];
        double t1 = points[0][ANGLE], t2 = points[1][ANGLE], t3 = points[2][ANGLE];
        double a1 = r1 * (r3 - r2), a2 = r2 * (r1 - r3), a3 = r3 * (r2 - r1);
        double tg = (a1 * Math.cos(t1) + a2 * Math.cos(t2) + a3 * Math.cos(t3)) /
                (a1 * Math.sin(t1) + a2 * Math.sin(t2) + a3 * Math.sin(t3));
        double angle = Math.atan(tg);
        double e = (r1 - r2) / (r2 * Math.cos(t2 + angle) - r1 * Math.cos(t1 + angle));
        double p = r1 * (1 + e * Math.cos(t1 + angle));
        return new Trajectory(e, p, angle, body.angle);
    }

    private static double[][] calculatePoints(Body body0, int count) {
        Body body = new Body(body0);
        double[][] points = new double[count][0];
        final double tau = .001;
        for (int i = 0; i <= 1000 * (count - 1); i++) {
            if (i % 1000 == 0)
                points[i / 1000] = new double[]{body.radiusVector, body.angle};
            body.radiusVector = MathUtils.moduleOfVector(body.x - body.centralBody.x, body.y - body.centralBody.y);
            body.angle = Math.atan2(body.y - body.centralBody.y, body.x - body.centralBody.x);
            double a = GRAVITATIONAL_CONSTANT * body.centralBody.mass / MathUtils.sqr(body.radiusVector);
            double[] acceleration = {Math.cos(Math.PI + body.angle) * a, Math.sin(Math.PI + body.angle) * a};
            body.velocity[X] += acceleration[X] * tau;
            body.velocity[Y] += acceleration[Y] * tau;
            body.x += body.velocity[X] * tau;
            body.y += body.velocity[Y] * tau;
        }
        return points;
    }
}
