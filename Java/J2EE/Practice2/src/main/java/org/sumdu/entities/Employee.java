package org.sumdu.entities;

import org.sumdu.exceptions.FieldLengthLimitException;
import org.sumdu.exceptions.IncorrectSalaryException;

import java.util.Objects;

public class Employee {

    protected static int nextId = 0;
    protected static final byte MAX_LENGTH = 50;

    protected final int id;
    protected int managerId;
    protected String name;
    protected String departmentName;
    protected double salary;

    public boolean dataCorruption;

    // Будь ласка коли викликаєте констуктор, managerId вказуйте через manager.getManagerId()
    public Employee(String name, String departmentName, double salary, int managerId) {
        // Флаг відповідаючий за те, чи скомпроментовані дані.
        // (Тобто якщо об'єкт створився не правильно, викинувши виключення)
        dataCorruption = false;

        id = nextId;
        nextId++;
        setManagerId(managerId);

        try {
            setName(name);
            setDepartmentName(departmentName);
            setSalary(salary);
        } catch (FieldLengthLimitException | IncorrectSalaryException e) {
            dataCorruption = true;
            System.out.println(e.getMessage());
        }
    }

    public void setDepartmentName(String departmentName) throws FieldLengthLimitException {
        if (departmentName.length() > MAX_LENGTH) {
            throw new FieldLengthLimitException(
                    "Занадто довге ім'я департаменту (ліміт "
                    + MAX_LENGTH + ")!"
            );
        } else {
            this.departmentName = departmentName;
        }
    }

    public void setName(String name) throws FieldLengthLimitException {
        if (name.length() > MAX_LENGTH) {
            throw new FieldLengthLimitException(
                    "Занадто довге ім'я (ліміт " + MAX_LENGTH + ")!"
            );
        } else {
            this.name = name;
        }
    }

    public void setSalary(double salary) throws IncorrectSalaryException {
        if (salary < 0) {
            throw new IncorrectSalaryException("Зарплатня не може бути негативною!");
        } else {
            this.salary = salary;
        }
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getId() {
        return id;
    }

    public int getManagerId() {
        return managerId;
    }

    public void printInfo() {
        if (dataCorruption) {
            System.out.println("printInfo: Не всі дані коректні.\n");
            return;
        }
        System.out.printf(
                "Працівник (ID %s):\nІм'я: %s\nЗарплата: %.2f\nНазва департаменту: %s\nID менеджеру: %s\n",
                id, name, salary, departmentName, managerId
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && managerId == employee.managerId && Double.compare(employee.salary, salary) == 0 && dataCorruption == employee.dataCorruption && Objects.equals(name, employee.name) && Objects.equals(departmentName, employee.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerId, name, departmentName, salary, dataCorruption);
    }
}
