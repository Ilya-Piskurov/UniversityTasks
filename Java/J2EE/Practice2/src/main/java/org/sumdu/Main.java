package org.sumdu;

import org.sumdu.entities.Employee;
import org.sumdu.entities.Manager;
import org.sumdu.exceptions.EmployeeInRegistryException;

public class Main {
    public static void main(String[] args) {
        var registry = Registry.getRegistry();

        var manager = new Manager("Sasha Grishenka", "HR", 20000, 2000, 0);
        var employeer = new Employee("Yaroslav Gorlach", "IT", 200, manager.getId());

        // Позитивний сценарій
        try {
            registry.addNewEmployee(manager);
            registry.addNewEmployee(employeer);
        } catch (EmployeeInRegistryException e) {
            System.out.println(e.getMessage());
        }
        registry.printList();

        // Негативний сценарій
        try {
            registry.addNewEmployee(employeer);
        } catch (EmployeeInRegistryException e) {
            System.out.println(e.getMessage());
        }
    }
}