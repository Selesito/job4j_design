package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {
    @Test
    public void whenAddThenDuplicates() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("first");
        array.add("two");
        Iterator<String> it = array.iterator();
        it.next();
        assertThat(it.next(), is("two"));
    }

    @Test
    public void whenAddThenNull() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add(null);
        array.add(null);
        array.add("two");
        Iterator<String> it = array.iterator();
        it.next();
        it.next();
        assertThat(it.next(), is("two"));
    }
}