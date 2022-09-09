package org.sumdu;

public class Employee {

    private static int nextId = 0;
    private final byte MAX_LENGTH = 15;

    private final int id;
    private String name;
    private String surname;
    private double salary;
    private boolean dataCorruption;

    public Employee(String name, String surname, double salary) {
        dataCorruption = false;
        id = nextId;
        nextId++;
        try {
            setName(name);
            setSurname(surname);
            setSalary(salary);
        } catch (FieldLengthLimitException | IncorrectSalaryException e) {
            dataCorruption = true;
            System.out.println(e.getMessage());
        }
        // По суті оскільки нас тут цікавить тільки повідомлення з
        // виключення, можна було б зловити одним catch(Exception e),
        // але зробив так, щоб продемонструвати наші кастомні виключення.
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

    public void setSurname(String surname) throws FieldLengthLimitException {
        if (surname.length() > MAX_LENGTH) {
            throw new FieldLengthLimitException(
                    "Занадтно довге прізвище (ліміт " + MAX_LENGTH + ")!"
            );
        } else {
            this.surname = surname;
        }
    }

    public void setSalary(double salary) throws IncorrectSalaryException {
        if (salary < 0) {
            throw new IncorrectSalaryException("Зарплатня не може бути негативною!");
        } else {
            this.salary = salary;
        }
    }

    public void printInfo() {
        if (dataCorruption) {
            System.out.println("printInfo: Не всі дані коректні.\n");
            return;
        }
        System.out.printf(
                "Працівник (ID %s):\nІм'я: %s\nПрізвище: %s\nЗарплата: %f\n\n",
                id, name, surname, salary
        );
    }
}
