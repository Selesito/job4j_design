package ru.job4j.serialization;

public class Surgeon {
    private final int experience;

    public Surgeon(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "Surgeon{"
                + "experience=" + experience
                + '}';
    }
}
