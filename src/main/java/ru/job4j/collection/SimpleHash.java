package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class SimpleHash<K, V> implements Iterable<Map.Entry<K, V>> {
    private int size = 16;
    private int count = 0;
    private Hash<K, V>[] hash = new Hash[size];

    private void checkLoad() {
        if (size * 0.70 > count) {
            return;
        } else {
            hash = Arrays.copyOf(hash, size * 2);
        }
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
        if (hash[index] != null) {
            return hash[index].getValue();
        }
        return null;
    }

    public boolean delete(K key) {
        int index = checkHash(key);
        if (hash[index] == null) {
            return false;
        }
        hash[index] = null;
        count--;
        return true;
    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new Iterator<Map.Entry<K, V>>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
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
            public Map.Entry<K, V> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Hash<K, V> rsl = hash[index++];
                return new Map.Entry<K, V>() {
                    @Override
                    public K getKey() {
                        return rsl.getKey();
                    }

                    @Override
                    public V getValue() {
                        return rsl.getValue();
                    }

                    @Override
                    public V setValue(V value) {
                        return null;
                    }
                };
            }
        };
    }
}
