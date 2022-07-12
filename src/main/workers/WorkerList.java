package main.workers;

import java.util.ArrayList;

public class WorkerList extends ArrayList<Worker> {

    public ArrayList<Worker> getType(WorkerType[] types) {
        ArrayList<Worker> workers = new ArrayList<Worker>();

        for (Worker worker : this) {
            for (WorkerType type : types) {
                if (worker.getType() == type) {
                    workers.add(worker);
                }
            }
        }

        return workers;
    }

}