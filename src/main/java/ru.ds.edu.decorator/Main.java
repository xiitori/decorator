package ru.ds.edu.decorator;

import ru.ds.edu.decorator.dec.*;
import ru.ds.edu.decorator.impl.DetailedErrorPrintable;
import ru.ds.edu.decorator.impl.SimplePrintable;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final int DEFAULT_BUFFER_SIZE = 10;

    public static void main(String[] args) {
        PrintableObjectsBuffer buffer = new PrintableObjectsBuffer(DEFAULT_BUFFER_SIZE);
        Map<String, String> map = new HashMap<>();

        Printable mapPrintable = new DetailedErrorPrintable(map, "Hello World!");
        Printable simplePrintable = new SimplePrintable("Всё идёт по плану");

        addPrintablesToBuffer(buffer, mapPrintable, simplePrintable);

        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");

        String[] forPrint = buffer.printObjects();
        for (String print: forPrint) {
            System.out.println(print);
        }
        System.out.println("-----------------------------------");

        map.put("four", "4");
        Printable t = buffer.get(0); //get map printable
        t.updateMessage("    Превышен рекомендованный размер.\r\n");

        forPrint = buffer.printObjects();
        for (String print: forPrint) {
            System.out.println(print);
        }
        System.out.println("-----------------------------------");

        // Необходимо добавить в буффер объекты Printable так,
        // чтобы при вызове метода printObject перед выводом getMessage в квадратных скобках выводился timestamp,
        // в который производился последний вызов метода Printable#updateMessage
        // [2024-03-13 14:01:01.813]Всё идёт по плану - пример
        // Реализовать ниже и для DetailedErrorPrintable и для SimplePrintable
        // TODO:

        buffer = new PrintableObjectsBuffer(DEFAULT_BUFFER_SIZE);
        SimpleTimestampDecorator simpleTimestampDecorator = new SimpleTimestampDecorator(simplePrintable);
        DetailedTimestampDecorator detailedTimestampDecorator = new DetailedTimestampDecorator(mapPrintable);
        addPrintablesToBuffer(buffer,simpleTimestampDecorator, detailedTimestampDecorator);

        forPrint = buffer.printObjects();
        for (String print: forPrint) {
            System.out.println(print);
        }
        System.out.println();

        simpleTimestampDecorator.updateMessage("Привет!");
        detailedTimestampDecorator.updateMessage("Превышен!");

        forPrint = buffer.printObjects();
        for (String print: forPrint) {
            System.out.println(print);
        }
        System.out.println("-----------------------------------");

        // Необходимо добавить в буффер объекты Printable так,
        // чтобы при вызове метода getMessage CamelCase был заменен на SnakeCase
        // Пример:
        // Error happened with object: java.util.HashMap@{one=1, two=2, three=3} : ->
        // Error happened with object: java.util.hash_map@{one=1, two=2, three=3} :
        // Реализовать ниже и для DetailedErrorPrintable и для SimplePrintable
        // TODO:

        buffer = new PrintableObjectsBuffer(DEFAULT_BUFFER_SIZE);
        SimpleSnakeCaseDecorator simpleSnakeCaseDecorator = new SimpleSnakeCaseDecorator(simplePrintable);
        DetailedSnakeCaseDecorator detailedSnakeCaseDecorator = new DetailedSnakeCaseDecorator(mapPrintable);
        addPrintablesToBuffer(buffer, detailedSnakeCaseDecorator, simpleSnakeCaseDecorator);

        forPrint = buffer.printObjects();
        for (String print: forPrint) {
            System.out.println(print);
        }
        System.out.println("-----------------------------------");

        // Необходимо добавить в буффер объекты Printable, результаты выполнения которых совмещают обе предыдущие
        // модификации
        // TODO:

        buffer = new PrintableObjectsBuffer(DEFAULT_BUFFER_SIZE);
        SimpleBothDecorator simpleBothDecorator = new SimpleBothDecorator(simplePrintable);
        DetailedBothDecorator detailedBothDecorator = new DetailedBothDecorator(mapPrintable);
        addPrintablesToBuffer(buffer, simpleBothDecorator, detailedBothDecorator);

        forPrint = buffer.printObjects();
        for (String print: forPrint) {
            System.out.println(print);
        }
        System.out.println();

        simpleBothDecorator.updateMessage("Привет!");
        detailedBothDecorator.updateMessage("Пока!");

        forPrint = buffer.printObjects();
        for (String print: forPrint) {
            System.out.println(print);
        }
    }

    private static void addPrintablesToBuffer(PrintableObjectsBuffer buff, Printable... printables) {
        for (Printable p: printables) {
            buff.add(p);
        }
    }
}
