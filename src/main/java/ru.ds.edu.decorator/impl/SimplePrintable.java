package ru.ds.edu.decorator.impl;

import ru.ds.edu.decorator.Printable;

// Код данного класса изменять нельзя!!!
public final class SimplePrintable implements Printable {
    private String message;

    public SimplePrintable(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void updateMessage(String message) {
        this.message = message;
    }
}
