package org.sumdu.task1;

public class Thread1 implements Runnable {

    private Bank bank;

    @Override
    public void run() {
        synchronized (bank) {
            for (int i = 0; i < 200000; i++) {
                bank.setAccount(bank.getAccount() + 2);
            }
        }
    }

    public Thread1(Bank bank) {
        this.bank = bank;
    }
}
