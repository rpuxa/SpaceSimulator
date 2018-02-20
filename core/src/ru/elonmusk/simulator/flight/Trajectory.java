package ru.elonmusk.simulator.flight;

/**
 * Класс траектории тела
 */
public class Trajectory {
    /** Эксцентриситет */
    double eccentricity;

    /** Большая полуось */
    double realAxis;

    /** Наклон большой полуоси */
    double incline;

    /** Аномалия тела */
    double anomaly;

    public Trajectory(double eccentricity, double realAxis, double incline, double anomaly) {
        this.eccentricity = eccentricity;
        this.realAxis = realAxis;
        this.incline = incline;
        this.anomaly = anomaly;
    }

    public double getFocalParameter() {
        return realAxis * (1 - eccentricity * eccentricity);
    }
}
