package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> simpleArray = new SimpleArray<>();

    public boolean add(T value) {
        boolean result = false;
        for (Object rsl : simpleArray) {
            if (Objects.equals(rsl, value)) {
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
