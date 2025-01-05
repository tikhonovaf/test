package sobes.simulation.basic;

public class ProductionCenter {
    private int id;
    private double processingTime; // время обработки одной детали
    private int employees; // количество сотрудников

    public ProductionCenter(int id, double processingTime) {
        this.id = id;
        this.processingTime = processingTime;
        this.employees = 0;
    }

    public int getId() {
        return id;
    }

    public double getProcessingTime() {
        return processingTime;
    }

    public int getEmployees() {
        return employees;
    }

    public void addEmployee() {
        employees++;
    }

    public void removeEmployee() {
        if (employees > 0) {
            employees--;
        }
    }

    public double getLoad(int pendingDetails) {
        return pendingDetails / (double) employees;
    }
}


