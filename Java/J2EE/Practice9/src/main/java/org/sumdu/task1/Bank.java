package org.sumdu.task1;

public class Bank {
    private int account;

    public void inc() {
        for (int i = 0; i < 200000; i++) {
            account += 2;
        }
    }

    public void dec() {
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
