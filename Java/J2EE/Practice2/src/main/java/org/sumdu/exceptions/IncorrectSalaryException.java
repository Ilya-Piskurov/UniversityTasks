package org.sumdu.exceptions;

public class IncorrectSalaryException extends Exception {
    public IncorrectSalaryException() {}
    public IncorrectSalaryException(String message) {
        super(message);
    }
}
