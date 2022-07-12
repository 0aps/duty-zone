package main.workers;

public class Contractor extends Worker {
    public static double rate = 312.75;
    public static double maxRate = rate * 1.06;

    public double getSalary() {
        double $rate = hours > workWeek ? maxRate : rate;

        return hours * $rate;
    }
}
