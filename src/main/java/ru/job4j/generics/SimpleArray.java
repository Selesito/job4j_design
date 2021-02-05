package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private T[] array;
    private int position = 0;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public T get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void set(int index, T model) {
        checkIndex(index);
        array[index] = model;
    }

    public void add(T model) {
        array[position++] = model;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        position--;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= this.position) {
            throw new  IndexOutOfBoundsException("Такого индекса нет!");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int positionIterator = 0;

            @Override
            public boolean hasNext() {
                return this.positionIterator < position;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[positionIterator++];
            }
        };
    }
}
