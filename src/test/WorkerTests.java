package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.workers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WorkersTests {

    @Test
    @DisplayName("Should calculate salary for contractors with standard rate")
    void shouldCalculateContractorStandardRate() {
        Worker worker = Worker.create(WorkerType.CONTRACTOR);
        int hours = 40;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(hours * Contractor.rate, worker.getSalary());
    }

    @Test
    @DisplayName("Should calculate salary for contractors with max rate")
    void shouldCalculateContractorMaxRate() {
        Worker worker = Worker.create(WorkerType.CONTRACTOR);
        int hours = 44;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(hours * Contractor.maxRate, worker.getSalary());
    }

    @Test
    @DisplayName("Should calculate salary for permanent half with standard rate")
    void shouldCalculatePermanentHalfStandardRate() {
        Worker worker = Worker.create(WorkerType.PERMANENT_HALF);
        int hours = 20;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(hours * PermanentHalf.rate, worker.getSalary());
    }

    @Test
    @DisplayName("Should calculate salary for permanent half with max rate")
    void shouldCalculatePermanentHalfRate() {
        Worker worker = Worker.create(WorkerType.PERMANENT_HALF);
        int hours = 24;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(hours * PermanentHalf.maxRate, worker.getSalary());
    }

    @Test
    @DisplayName("Should calculate salary for permanent full with standard rate")
    void shouldCalculatePermanentFullStandardRate() {
        Worker worker = Worker.create(WorkerType.PERMANENT_FULL);
        int hours = 40;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(hours * PermanentFull.rate, worker.getSalary());
    }

    @Test
    @DisplayName("Should calculate salary for permanent full with max rate")
    void shouldCalculatePermanentMaxRate() {
        Worker worker = Worker.create(WorkerType.PERMANENT_FULL);
        int hours = 44;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(hours * PermanentFull.maxRate, worker.getSalary());
    }

    @Test
    @DisplayName("Should calculate insurance deduction")
    void shouldCalculateInsuranceDeduction() {
        Worker worker = Worker.create(WorkerType.CONTRACTOR);
        int hours = 44;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(worker.getSalary() * Worker.insuranceRate, worker.getInsuranceDeduction());
    }

    @Test
    @DisplayName("Should calculate insurance deduction")
    void shouldCalculateRentDeduction() {
        Worker worker = Worker.create(WorkerType.CONTRACTOR);
        int hours = 44;

        worker.setCode("0001");
        worker.setName("JoseA");
        worker.setDescription("Ingeniero");
        worker.setHours(hours);

        assertEquals(worker.getSalary() * Worker.rentRate, worker.getRentDeduction());
    }
}