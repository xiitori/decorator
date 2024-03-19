package ru.ds.edu.decorator.dec;

import ru.ds.edu.decorator.Printable;

import java.sql.Timestamp;
import java.util.Date;

public class SimpleBothDecorator extends AbstractPrintableDecorator {

    private Timestamp timestamp;
    public SimpleBothDecorator(Printable obj) {
        super(obj);
    }

    @Override
    public String getMessage() {
        String time = timestamp == null ? "" : timestamp.toString();
        String message = DecoratorUtils.snakeCaseMessage(super.getMessage());

        return String.format("[%s]%s", time, message);
    }

    @Override
    public void updateMessage(String text) {
        timestamp = new Timestamp(new Date().getTime());
        super.updateMessage(text);
    }
}
