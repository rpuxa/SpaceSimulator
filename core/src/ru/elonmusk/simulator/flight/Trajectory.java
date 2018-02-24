package ru.elonmusk.simulator.flight;

/**
 * Класс траектории тела
 */
public class Trajectory {
    /** Эксцентриситет */
    double eccentricity;

    /** Фокальный параметр */
    double focalParameter;

    /** Наклон большой полуоси */
    double incline;

    /** Аномалия тела */
    double anomaly;

    public Trajectory(double eccentricity, double focalParameter, double incline, double anomaly) {
        this.eccentricity = eccentricity;
        this.focalParameter = focalParameter;
        this.incline = incline;
        this.anomaly = anomaly;
    }
}
