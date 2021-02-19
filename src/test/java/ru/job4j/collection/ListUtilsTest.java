package ru.job4j.collection;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 4));
        ListUtils.addAfter(input, 1, 3);
        assertThat(Arrays.asList(1, 2, 3, 4), Is.is(input));
    }

    @Test
    public void whenAddRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ListUtils.removeIf(input,  s -> s > 2);
        assertThat(Arrays.asList(1, 2), Is.is(input));
    }

    @Test
    public void whenAddReplaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(5, 6, 3, 4));
        ListUtils.replaceIf(input,  s -> s > 4, -1);
        assertThat(Arrays.asList(-1, -1, 3, 4), Is.is(input));
    }

    @Test
    public void whenAddRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> check = new ArrayList<>(Arrays.asList(3, 4, 5));
        ListUtils.removeAll(input, check);
        assertThat(Arrays.asList(1, 2, 6, 7), Is.is(input));
    }
}