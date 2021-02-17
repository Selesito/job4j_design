package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();
    private int size = 0;

    public int getSize() {
        return size;
    }

    public T pop() {
        size--;
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
        size++;
    }
}
