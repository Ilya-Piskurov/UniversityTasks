package org.sumdu.task1;

public class Thread2 implements Runnable {

    private final Bank bank;

    public Thread2(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        synchronized (bank) {
            for (int i = 0; i < 200000; i++) {
                bank.setAccount(bank.getAccount() - 1);
            }
        }
    }

}
