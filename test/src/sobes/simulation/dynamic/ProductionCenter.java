package sobes.simulation.dynamic;

public class ProductionCenter {
    private int id;
    private double processingTime; // время обработки одной детали
    private int employees; // количество сотрудников
    private int pendingDetails; // количество деталей, ожидающих обработки

    public ProductionCenter(int id, double processingTime, int pendingDetails) {
        this.id = id;
        this.processingTime = processingTime;
        this.pendingDetails = pendingDetails;
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

    public double getLoad() {
        return pendingDetails / (double) employees;
    }

    public void processDetails() {
        int processedDetails = (int) (employees * (1 / processingTime));
        pendingDetails = Math.max(0, pendingDetails - processedDetails);
    }

    public int getPendingDetails() {
        return pendingDetails;
    }
}
