package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Autopark {
    private final String nameCompany;
    private final int countCar;
    private final String[] passenger;
    private final boolean close;
    private final Bus bus;

    public Autopark(String nameCompany, int countCar, String[] passenger, boolean close, Bus bus) {
        this.nameCompany = nameCompany;
        this.countCar = countCar;
        this.passenger = passenger;
        this.close = close;
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Autopark{"
                + "nameCompany='" + nameCompany + '\''
                + ", countCar=" + countCar
                + ", passenger=" + Arrays.toString(passenger)
                + ", close=" + close
                + ", bus=" + bus + '}';
    }

    public static void main(String[] args) {
        final Autopark auto = new Autopark("Moroz", 30,
                new String[] {"Петров", "Федоров"}, true, new Bus("ПАЗ"));

        final Gson gson = new GsonBuilder().create();
        String autoJson = gson.toJson(auto);
        System.out.println(gson.toJson(autoJson));
        final Autopark autoMod = gson.fromJson(autoJson, Autopark.class);
        System.out.println(autoMod);
    }
}
