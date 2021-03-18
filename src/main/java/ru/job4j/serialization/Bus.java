package ru.job4j.serialization;

public class Bus {
    private final String brand;

    public Bus(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Bus{"
                + "brand='" + brand + '\''
                + '}';
    }
}
