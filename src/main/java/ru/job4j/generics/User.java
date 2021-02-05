package ru.job4j.generics;

public class User extends Base {
    private String id;

    protected User(String id, String name, String surname) {
        super(id);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
