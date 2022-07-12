package main.workers;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

abstract public class Worker {
    public static double insuranceRate = 0.02;
    public static double rentRate = 0.07;
    final int workWeek = 40;

    String code;
    String name;
    String description;
    WorkerType type;
    int hours;

    public Worker() {
    }

    public static Worker create(WorkerType type) {
        Worker worker;
        switch (type) {
            case CONTRACTOR:
                worker = new Contractor();
                break;
            case PERMANENT_FULL:
                worker = new PermanentFull();
                break;
            case PERMANENT_HALF:
                worker = new PermanentHalf();
                break;
            default:
                throw new IllegalArgumentException("Tipo de trabajador inválido");
        }

        worker.setType(type);
        return worker;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WorkerType getType() {
        return type;
    }

    public void setType(WorkerType type) {
        this.type = type;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getSalary() {
        throw new NotImplementedException();
    }

    public double getInsuranceDeduction() {
        return getSalary() * insuranceRate;
    }

    public double getRentDeduction() {
        return getSalary() * rentRate;
    }

    public double getNetSalary() {
        return getSalary() - getInsuranceDeduction() - getRentDeduction();
    }

}
