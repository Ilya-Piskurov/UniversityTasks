package org.sumdu;

import org.sumdu.entities.Employee;
import org.sumdu.entities.Manager;
import org.sumdu.exceptions.FieldLengthLimitException;
import org.sumdu.exceptions.IncorrectSalaryException;

public class CompositorPatternDemo {
    public static void main(String[] args) {
        try {

            var headOfCompany = new Manager("Ілля Піскурьов", "Керування",
                    100_000, 50_000, Employee.nextId);
            var manager1 = new Manager("Ярослав Горлач", "IT",
                    40_000, 10_000, headOfCompany.getId());
            var employee1 = new Employee("Максим Червяков", "QA",
                    10_000, manager1.getId());
            var employee2 = new  Employee("Олександра Грищенко", "TA",
                    5_000, manager1.getId());

            manager1.add(employee1);
            manager1.add(employee2);
            headOfCompany.add(manager1);

            printAllEmployees(headOfCompany);

        } catch (IncorrectSalaryException | FieldLengthLimitException e) {
            System.out.println(e.getMessage());
        }
    }

    // Рекурсивна функція виводу всієї ієрархії співпрацівників.
    public static void printAllEmployees(Employee headOfCompany) {
        System.out.println(headOfCompany);
        for (var empl: headOfCompany.getSubordinates()) {
            printAllEmployees(empl);
        }
    }
}