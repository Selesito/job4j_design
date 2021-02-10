package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[1];
    private int size = 0;
    private int modCount = 0;

    public void add(T model) {
        if (size == container.length - 1) {
            upgrade(container.length * 2);
        }
        container[size++] = model;
        modCount++;
    }

    public Object get(int index) {
        checkIndex(index);
        modCount++;
        return container[index];
    }

    public void set(int index, T model) {
        checkIndex(index);
        container[index] = model;
        modCount++;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(container, index + 1, container, index, container.length - 1 - index);
        size--;
        modCount++;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new  IndexOutOfBoundsException("Такого индекса нет!");
        }
    }

    private void upgrade(int length) {
        Object[] rsl = new Object[length];
        System.arraycopy(container, 0, rsl, 0, size);
        container = rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int positionIterator = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return this.positionIterator < size;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[positionIterator++];
            }
        };
    }
}