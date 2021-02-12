package ru.job4j.generics;

public class Role extends Base {
    private String id;

    public Role(String id, String name, String surname) {
        super(id);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}

