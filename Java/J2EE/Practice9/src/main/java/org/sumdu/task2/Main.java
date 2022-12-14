package org.sumdu.task2;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Bank bank = new Bank();

        Thread thread = new Thread(new Thread1(bank));
        thread.start();
        Thread thread2 = new Thread(new Thread2(bank));
        thread2.start();

        thread.join();
        thread2.join();

        System.out.println(bank.getAccount());
    }

}