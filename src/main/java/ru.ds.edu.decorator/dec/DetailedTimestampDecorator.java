package ru.ds.edu.decorator.dec;

import ru.ds.edu.decorator.Printable;

import java.sql.Timestamp;
import java.util.Date;

public class DetailedTimestampDecorator extends AbstractPrintableDecorator {

    private Timestamp timestamp;
    public DetailedTimestampDecorator(Printable obj) {
        super(obj);
    }

    @Override
    public String getMessage() {
        String time = timestamp == null ? "" : timestamp.toString();

        return String.format("[%s]%s", time, super.getMessage());
    }

    @Override
    public void updateMessage(String text) {
        timestamp = new Timestamp(new Date().getTime());
        super.updateMessage(text);
    }
}
