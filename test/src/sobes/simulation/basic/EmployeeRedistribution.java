package sobes.simulation.basic;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRedistribution {

    private List<ProductionCenter> centers;
    private int totalEmployees;

    public EmployeeRedistribution(List<ProductionCenter> centers, int totalEmployees) {
        this.centers = centers;
        this.totalEmployees = totalEmployees;
    }

    public void redistributeEmployees(int[] pendingDetails) {
        while (true) {
            ProductionCenter maxLoadCenter = null;
            ProductionCenter minLoadCenter = null;
            double maxLoad = Double.MIN_VALUE;
            double minLoad = Double.MAX_VALUE;

            for (int i = 0; i < centers.size(); i++) {
                ProductionCenter center = centers.get(i);
                double load = center.getLoad(pendingDetails[i]);
                if (load > maxLoad) {
                    maxLoad = load;
                    maxLoadCenter = center;
                }
                if (load < minLoad) {
                    minLoad = load;
                    minLoadCenter = center;
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
    public static void main(String[] args) {
        List<ProductionCenter> centers = new ArrayList<>();
        centers.add(new ProductionCenter(1, 2.0));
        centers.add(new ProductionCenter(2, 1.5));
        centers.add(new ProductionCenter(3, 3.0));

        int totalEmployees = 10;
        int[] pendingDetails = {10, 20, 15};

        EmployeeRedistribution redistribution = new EmployeeRedistribution(centers, totalEmployees);

// Инициализация сотрудников
        for (int i = 0; i < totalEmployees; i++) {
            centers.get(i % centers.size()).addEmployee();
        }

        redistribution.redistributeEmployees(pendingDetails);

        for (ProductionCenter center : centers) {
            System.out.println("ПЦ " + center.getId() + ": " + center.getEmployees() + " сотрудников");
        }
    }

}
