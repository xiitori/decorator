package ru.ds.edu.decorator;

// Код данного класса изменять нельзя!!!
public class PrintableObjectsBuffer {
    private final Printable[] objs;
    private int last = 0;

    public PrintableObjectsBuffer(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Длина списка должна быть больше 0");
        }
        objs = new Printable[n];
    }

    public void add(Printable obj) {
        if (last >= objs.length) {
            throw new IndexOutOfBoundsException("Список уже полон");
        }
        objs[last] = obj;
        last++;
    }

    public Printable get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс должен быть неотрицательным");
        }
        if (index > last) {
            throw new IndexOutOfBoundsException("В буффере нет элемента с таким индексом");
        }
        return objs[index];
    }

    public boolean isFull() {
        return last == objs.length;
    }

    public String[] printObjects() {
        String[] res = new String[last];
        for (int i = 0; i < last; i++) {
            res[i] = objs[i].getMessage();
        }
        return res;
    }
}