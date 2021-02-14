package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ContainerLinked<E> implements Iterable<E> {
    private Node<E> node;
    private int modCount = 0;
    private int size = 0;

    public void add(E model) {
        if (node == null) {
            node = new Node<>(null, model, null);
        } else {
            Node<E> result = new Node<>(node, model, null);
            node = result;
        }
        modCount++;
        size++;
    }

    public E get(int index) {
        Node<E> current = node;
        Objects.checkIndex(index, size);
        if (index == 0) {
            return node.item;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.item;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> temp = node;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                Node<E> result = temp;
                temp = node.next;
                return result.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
