package ru.ds.edu.decorator.dec;

import ru.ds.edu.decorator.Printable;

// Код данного класса изменять нельзя!!!
public abstract class AbstractPrintableDecorator implements Printable {
    private final Printable decoratee;

    public AbstractPrintableDecorator(Printable obj) {
        this.decoratee = obj;
    }

    @Override
    public String getMessage() {
        return decoratee.getMessage();
    }

    @Override
    public void updateMessage(String text) {
        decoratee.updateMessage(text);
    }
}
