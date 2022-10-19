package org.sumdu.entities;

import org.sumdu.exceptions.FieldLengthLimitException;
import org.sumdu.exceptions.IncorrectSalaryException;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Employee {

    public static int nextId = 0;
    protected static final byte MAX_LENGTH = 50;

    protected final int id;
    protected int managerId;
    protected String name;
    protected String departmentName;
    protected double salary;
    protected List<Employee> subordinates = new LinkedList<>();

    public Employee(String name, String departmentName, double salary, int managerId)
           throws IncorrectSalaryException, FieldLengthLimitException {

        id = nextId;
        nextId++;

        setManagerId(managerId);
        setName(name);
        setDepartmentName(departmentName);
        setSalary(salary);
    }

    public void add(Employee empl) {
        subordinates.add(empl);
    }

    public void remove(Employee empl) {
        subordinates.remove(empl);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public int getId() {
        return id;
    }

    public void setManagerId(int id) {
        managerId = id;
    }

    public int getManagerId() {
        return managerId;
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

    public String toString() {
        return String.format(
                "Працівник (ID %s):\nІм'я: %s\nЗарплата: %.2f\nНазва департаменту: %s\nID менеджеру: %s\n",
                id, name, salary, departmentName, managerId
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Double.compare(employee.salary, salary) == 0 && managerId == employee.managerId &&
                Objects.equals(name, employee.name) && Objects.equals(departmentName, employee.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, managerId, name, departmentName, salary);
    }
}
