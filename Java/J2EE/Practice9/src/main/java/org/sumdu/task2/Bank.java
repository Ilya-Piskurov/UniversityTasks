package org.sumdu.task2;

public class Bank {
    private int account;

    public synchronized void inc() {
        for (int i = 0; i < 200000; i++) {
            account += 2;
        }
    }

    public synchronized void dec() {
        for (int i = 0; i < 200000; i++) {
            account -= 1;
        }
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public int getAccount() {
        return account;
    }
}
