package ru.ds.edu.decorator.dec;

import ru.ds.edu.decorator.Printable;
import ru.ds.edu.decorator.impl.DetailedErrorPrintable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetailedSnakeCaseDecorator extends AbstractPrintableDecorator {

    private final DetailedErrorPrintable printable;

    public DetailedSnakeCaseDecorator(Printable obj) {
        super(obj);
        printable = (DetailedErrorPrintable) obj;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        return DecoratorUtils.snakeCaseMessage(message);
    }

    @Override
    public void updateMessage(String text) {
        super.updateMessage(text);
    }
}
