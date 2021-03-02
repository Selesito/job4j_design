package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {

    @Test
    public void whenAdded0Changed2Deleted2() {
        List<Analize.User> prev = new ArrayList<>();
        prev.add(new Analize.User(1, "Petr1"));
        prev.add(new Analize.User(2, "Petr2"));
        prev.add(new Analize.User(3, "Petr3"));
        prev.add(new Analize.User(4, "Petr4"));
        prev.add(new Analize.User(7, "Petr7"));
        prev.add(new Analize.User(8, "Petr8"));
        List<Analize.User> current = new ArrayList<>();
        current.add(new Analize.User(1, "Petr1"));
        current.add(new Analize.User(2, "Petr8"));
        current.add(new Analize.User(3, "Petr9"));
        current.add(new Analize.User(4, "Petr4"));
        Analize.Info rsl = new Analize().diff(prev, current);
        assertThat(rsl.getChanged(), is(2));
        assertThat(rsl.getAdded(), is(0));
        assertThat(rsl.getDeleted(), is(2));
    }

    @Test
    public void whenAdded0Changed0Deleted0() {
        List<Analize.User> prev = new ArrayList<>();
        prev.add(new Analize.User(1, "Petr1"));
        prev.add(new Analize.User(2, "Petr2"));
        prev.add(new Analize.User(3, "Petr3"));
        prev.add(new Analize.User(4, "Petr4"));
        List<Analize.User> current = new ArrayList<>();
        current.add(new Analize.User(1, "Petr1"));
        current.add(new Analize.User(2, "Petr2"));
        current.add(new Analize.User(3, "Petr3"));
        current.add(new Analize.User(4, "Petr4"));
        Analize.Info rsl = new Analize().diff(prev, current);
        assertThat(rsl.getChanged(), is(0));
        assertThat(rsl.getAdded(), is(0));
        assertThat(rsl.getDeleted(), is(0));
    }

    @Test
    public void whenAdded1Changed2Deleted1() {
        List<Analize.User> prev = new ArrayList<>();
        prev.add(new Analize.User(1, "Petr1"));
        prev.add(new Analize.User(2, "Petr2"));
        prev.add(new Analize.User(3, "Petr3"));
        prev.add(new Analize.User(4, "Petr4"));
        List<Analize.User> current = new ArrayList<>();
        current.add(new Analize.User(1, "Petr1"));
        current.add(new Analize.User(2, "Petr8"));
        current.add(new Analize.User(3, "Petr9"));
        current.add(new Analize.User(7, "Petr7"));
        Analize.Info rsl = new Analize().diff(prev, current);
        assertThat(rsl.getAdded(), is(1));
        assertThat(rsl.getChanged(), is(2));
        assertThat(rsl.getDeleted(), is(1));
    }
}