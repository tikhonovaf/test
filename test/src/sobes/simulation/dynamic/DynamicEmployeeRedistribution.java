package sobes.simulation.dynamic;

import java.util.ArrayList;
import java.util.List;

public class DynamicEmployeeRedistribution {
    private List<ProductionCenter> centers;
    private int totalEmployees;

    public DynamicEmployeeRedistribution(List<ProductionCenter> centers, int totalEmployees) {
        this.centers = centers;
        this.totalEmployees = totalEmployees;
    }

    public void redistributeEmployees() {
        double maxLoad = Double.MIN_VALUE;
        double minLoad = Double.MAX_VALUE;
        while (true) {
            ProductionCenter maxLoadCenter = null;
            ProductionCenter minLoadCenter = null;

            for (ProductionCenter center : centers) {
                if (center.getEmployees() > 0) {
                    double load = center.getLoad();
                    if (load > maxLoad) {
                        maxLoad = load;
                        maxLoadCenter = center;
                    }
                    if (load < minLoad) {
                        minLoad = load;
                        minLoadCenter = center;
                    }
                }
            }

            if (maxLoadCenter != null && minLoadCenter != null && maxLoad > minLoad) {
                minLoadCenter.removeEmployee();
                maxLoadCenter.addEmployee();
            } else {
                break;
            }
        }
    }

    public void processAllDetails() {
        for (ProductionCenter center : centers) {
            center.processDetails();
        }
    }

    public static void main(String[] args) {
        List<ProductionCenter> centers = new ArrayList<>();
        centers.add(new ProductionCenter(1, 2.0, 10));
        centers.add(new ProductionCenter(2, 1.5, 20));
        centers.add(new ProductionCenter(3, 3.0, 15));

        int totalEmployees = 10;

        DynamicEmployeeRedistribution redistribution = new DynamicEmployeeRedistribution(centers, totalEmployees);

// Инициализация сотрудников
        for (int i = 0; i < totalEmployees; i++) {
            centers.get(i % centers.size()).addEmployee();
        }

// Основной цикл перераспределения и обработки
        while (centers.stream()
                .anyMatch(center -> center.getPendingDetails() > 0)) {
            redistribution.redistributeEmployees();
            redistribution.processAllDetails();
        }

        for (ProductionCenter center : centers) {
            System.out.println("ПЦ " + center.getId() + ": " + center.getEmployees() + " сотрудников, " + center.getPendingDetails() + " оставшихся деталей");
        }
    }
}
