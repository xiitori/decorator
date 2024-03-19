package ru.ds.edu.decorator.dec;

import ru.ds.edu.decorator.Printable;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleSnakeCaseDecorator extends AbstractPrintableDecorator {
    public SimpleSnakeCaseDecorator(Printable obj) {
        super(obj);
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
