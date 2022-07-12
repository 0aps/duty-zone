package main.workers;

public class PermanentFull extends Worker {
    public static double rate = 395.15;
    public static double maxRate = rate * 1.17;

    public double getSalary() {
        double $rate = hours > workWeek ? maxRate : rate;

        return hours * $rate;
    }
}
