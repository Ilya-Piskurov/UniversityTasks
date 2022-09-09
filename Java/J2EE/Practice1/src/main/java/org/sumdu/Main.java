package org.sumdu;

public class Main {
    public static void main(String[] args) {
        //Позитивний сценарій
        System.out.println("Позитивний сценарій (коректні дані):");
        Employee enjoyer = new Employee("Ілля", "Піскурьов", 15000.50);
        enjoyer.printInfo();

        //Негативний сценарій
        System.out.println("Негативний сценарій (некоректні дані):");
        Employee developer = new Employee("Bernd", "Ottovordemgentschenfelde", 20);
        developer.printInfo();

        //Виключення у main()
        try {
            System.out.println("Спроба присвоїти негативне значення зарплаті.");
            developer.setSalary(-2000);
        } catch (IncorrectSalaryException e) {
            System.out.println(e.getMessage());
        }
    }
}