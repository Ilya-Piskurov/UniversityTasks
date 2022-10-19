package org.sumdu.entities;

import org.sumdu.exceptions.FieldLengthLimitException;
import org.sumdu.exceptions.IncorrectSalaryException;
import java.util.Objects;

public class Manager extends Employee {

    protected double bonus;

    public Manager(String name, String departmentName, double salary, double bonus, int managerId)
            throws IncorrectSalaryException, FieldLengthLimitException {

        super(name, departmentName, salary, managerId);

        setBonus(bonus);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) throws IncorrectSalaryException {
        if (bonus < 0) {
            throw new IncorrectSalaryException("Бонус не може бути негативним!");
        } else {
            this.bonus = bonus;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Працівник (ID %s):\nІм'я: %s\nЗарплата: %.2f\nПремія: %.2f\nНазва департаменту: %s\nID менеджеру: %s\n",
                id, name, salary, bonus, departmentName, managerId
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.bonus, bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }
}
