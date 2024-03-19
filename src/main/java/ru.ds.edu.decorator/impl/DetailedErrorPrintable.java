package ru.ds.edu.decorator.impl;

import ru.ds.edu.decorator.Printable;

// Код данного класса изменять нельзя!!!
public final class DetailedErrorPrintable implements Printable {
    private String message;
    private final Object target;

    public DetailedErrorPrintable(Object target) {
        this.target = target;
        message = "";
    }

    public DetailedErrorPrintable(Object target, String message) {
        this.target = target;
        this.message = message;
    }

    @Override
    public String getMessage() {
        String sb = "Error happened with object: " + target.getClass().getCanonicalName() +
                "@" +
                target +
                ": " +
                message;
        return sb;
    }

    @Override
    public void updateMessage(String message) {
        this.message = message.trim();
    }
}
