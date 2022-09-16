package org.sumdu;

import org.sumdu.entities.Employee;
import org.sumdu.exceptions.EmployeeInRegistryException;

import java.util.LinkedList;
import java.util.List;

// Це синглтон
public class Registry {

    private static final Registry WorkersRegistry = new Registry();

    private final List<Employee> workers = new LinkedList<>();

    private Registry() {}

    public static Registry getRegistry() {
        return WorkersRegistry;
    }

    public void addNewEmployee(Employee employee) throws EmployeeInRegistryException {
        if (workers.contains(employee)) {
            throw new EmployeeInRegistryException(
                    "Не можна два рази найняти одного й того самого працівника!"
            );
        } else {
            workers.add(employee);
        }
    }

    public void printList() {
        System.out.println("-----------------------------------------");
        System.out.println("Вивожу список зареестрованих працівників:");
        for (Employee element: workers) {
            element.printInfo();
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }
}
