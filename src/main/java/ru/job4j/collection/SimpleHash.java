package ru.job4j.collection;

import java.util.*;

public class SimpleHash<K, V> implements Iterable<Hash<K, V>> {
    private int size = 16;
    private int count = 0;
    private Hash<K, V>[] hash = new Hash[size];

    private void checkLoad() {
        if (size * 0.75 > count) {
            return;
        }
        size *= 2;
        Hash<K, V>[] temp = new Hash[size];
        for (Hash rsl : hash) {
            if (rsl != null) {
                K key = (K) rsl.getKey();
                V value = (V) rsl.getValue();
                int index = checkHash(key);
                temp[index] = new Hash<K, V>(key, value);
            }
        }
        this.hash = temp;
        count++;
    }

    private int checkHash(K key) {
        return key.hashCode() % size;
    }

    public boolean insert(K key, V value) {
        checkLoad();
        int index = checkHash(key);
        if (hash[index] != null) {
            return false;
        }
        hash[index] = new Hash<K, V>(key, value);
        count++;
        return true;
    }

    public V get(K key) {
        int index = checkHash(key);
        if (hash[index] != null && hash[index].getKey().equals(key)) {
            return hash[index].getValue();
        }
        return null;
    }

    public boolean delete(K key) {
        int index = checkHash(key);
        if (hash[index] == null || !hash[index].getKey().equals(key)) {
            return false;
        }
        hash[index] = null;
        count--;
        return true;
    }

    @Override
    public Iterator<Hash<K, V>> iterator() {
        return new Iterator<Hash<K, V>>() {
            private int index = 0;
            private int expectedModCount = count;
            @Override
            public boolean hasNext() {
                if (this.expectedModCount != count) {
                    throw new ConcurrentModificationException("Коллекция была изменена.");
                }
                if (index < size) {
                    for (int i = index; i < size; i++) {
                        if (hash[i] != null) {
                            break;
                        }
                        index++;
                    }
                }
                return index < size;
            }

            @Override
            public Hash<K, V> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Hash<K, V> rsl = hash[index++];
                return new Hash<>(rsl.getKey(), rsl.getValue()) {
                    @Override
                    public K getKey() {
                        return rsl.getKey();
                    }

                    @Override
                    public V getValue() {
                        return rsl.getValue();
                    }
                };
            }
        };
    }
}
