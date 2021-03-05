package ru.job4j.io;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "pair_without_comment.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenKeyValue() {
        String path = "pair_without_comment.txt";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("names"),
                is("Petr Arsentev")
        );
    }
}