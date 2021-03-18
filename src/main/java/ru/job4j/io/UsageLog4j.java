package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        long height = 180;
        char sex = 'M';
        boolean children = true;
        float weight = 79.6F;
        double speed = 16.4;
        short scope = 132;
        byte step = 87;

        LOG.debug("User info name : {}, age : {}, height : {}, sex : {}, children : {},"
                + " weight : {}, speed : {}, scope : {}, step : {}", name, age, height,
                sex, children, weight, speed, scope, step);
    }
}