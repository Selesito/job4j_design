package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray simpleArray = new SimpleArray();

    public boolean add(T value) {
        boolean result = false;
        for (Object rsl : simpleArray) {
            if (rsl.equals(value)) {
                result = true;
                break;
            }
        }
        if (!result) {
            simpleArray.add(value);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return simpleArray.iterator();
    }
}
