package ru.job4j.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("Misha", 1,
                new GregorianCalendar(2017, Calendar.JANUARY, 25));
        User user2 = new User("Misha", 1,
                new GregorianCalendar(2017, Calendar.JANUARY, 25));
        Map<User, Object> user = new HashMap<>();
        user.put(user1, user1);
        user.put(user2, user2);
        user.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}

