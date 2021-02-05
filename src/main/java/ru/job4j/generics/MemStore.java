package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T value = findById(id);
        if (value != null) {
            mem.set(mem.indexOf(value), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        T value = findById(id);
        if (value != null) {
            return mem.remove(id);
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}