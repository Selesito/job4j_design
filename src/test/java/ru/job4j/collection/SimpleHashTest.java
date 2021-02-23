package ru.job4j.collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

public class SimpleHashTest {
    @Test
    public void testMapMap() {
        SimpleHash<String, Integer> map = new SimpleHash<String, Integer>();
        map.insert("Lars1", 11);
        map.insert("Lars2", 21);
        map.insert("Lars3", 12);
        assertThat(map.get("Lars2"), is(21));
        map.delete("Lars2");
        assertNull(map.get("Lars2"));
    }

    @Test
    public void testMapDuplicate() {
        SimpleHash<String, Integer> map = new SimpleHash<>();
        map.insert("Lars1", 11);
        map.insert("Lars1", 21);
        map.insert("Lars3", 12);
        assertThat(map.get("Lars1"), is(11));
    }

    @Test
    public void testMapIterator() {
        SimpleHash<String, Integer> map = new SimpleHash<>();
        map.insert("Lars1", 11);
        map.insert("Lars1", 21);
        map.insert("Lars3", 12);
        Iterator<Map.Entry<String, Integer>> rsl = map.iterator();
        assertThat(rsl.next().getValue(), is(11));
        assertThat(rsl.next().getValue(), is(12));
    }
}