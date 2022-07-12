package main.workers;

public class PermanentHalf extends Worker {
    public static double rate = 293.65;
    public static double maxRate = rate * 1.185;

    public double getSalary() {
        double $rate = hours > workWeek / 2 ? maxRate : rate;

        return hours * $rate;
    }
}
