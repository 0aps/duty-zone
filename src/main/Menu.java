package main;

import main.workers.Worker;
import main.workers.WorkerList;
import main.workers.WorkerType;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    WorkerList workers = new WorkerList();
    String[] options = {"Procesar pago semanal", "Ver trabajadores temporales",
            "Ver trabajadores permanentes", "Ver todos los trabajadores", "Salir"};
    Scanner scan = new Scanner(System.in);

    public void show() {
        int selected;
        System.out.println("Menu.");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s.%n", i + 1, options[i]);
        }

        System.out.print("\n> ");
        selected = scan.nextInt();
        processOptions(selected);
    }

    private void processOptions(int selected) {
        switch (selected) {
            case 1:
                processPaymentOption();
                break;
            case 2:
                viewWorkers(new WorkerType[]{WorkerType.CONTRACTOR});
                break;
            case 3:
                viewWorkers(new WorkerType[]{WorkerType.PERMANENT_FULL, WorkerType.PERMANENT_HALF});
                break;
            case 4:
                viewWorkers(new WorkerType[]{WorkerType.CONTRACTOR, WorkerType.PERMANENT_FULL,
                        WorkerType.PERMANENT_HALF});
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Opción inválida, vuelve a intentar. \n\n");
        }
    }

    private void processPaymentOption() {
        int workersAmount, workerType;

        System.out.print("Ingrese el número de trabajadores: ");
        workersAmount = scan.nextInt();

        for (int i = 0; i < workersAmount; i++) {
            System.out.printf("Trabajador #%d:%n", i + 1);

            System.out.print("\tTipo:");
            System.out.print("\n\t\t1. Contratista\n\t\t2. Fijo medio tiempo\n\t\t3. Fijo tiempo completo");
            System.out.print("\n> ");
            workerType = scan.nextInt();

            Worker currentWorker = Worker.create(WorkerType.values()[workerType - 1]);

            System.out.print("\tCódigo: ");
            currentWorker.setCode(scan.next());

            System.out.print("\tNombre: ");
            currentWorker.setName(scan.next());

            System.out.print("\tDescripción: ");
            currentWorker.setDescription(scan.next());

            System.out.print("\tHoras trabajadas: ");
            currentWorker.setHours(scan.nextInt());

            workers.add(currentWorker);
        }
    }

    void viewWorkers(WorkerType[] types) {
        ArrayList<Worker> $workers = workers.getType(types);
        int workersAmount = $workers.size();

        for (int i = 0; i < workersAmount; i++) {
            Worker currentWorker = $workers.get(i);
            System.out.printf("Trabajador #%d:\n", i + 1);
            System.out.printf("\n\tCódigo: %s", currentWorker.getCode());
            System.out.printf("\n\tNombre: %s", currentWorker.getName());
            System.out.printf("\n\tDescripción: %s", currentWorker.getDescription());
            System.out.printf("\n\tTipo: %s", currentWorker.getType());
            System.out.printf("\n\tSalario bruto: RD$%.2f", currentWorker.getSalary());
            System.out.printf("\n\tSeguro médico: RD$%.2f", currentWorker.getInsuranceDeduction());
            System.out.printf("\n\tImpuesto sobre la renta: RD$%.2f", currentWorker.getRentDeduction());
            System.out.printf("\n\tSalario neto: RD$%.2f\n\n", currentWorker.getNetSalary());
        }
    }
}
