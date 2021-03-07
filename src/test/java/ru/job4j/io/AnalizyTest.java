package ru.job4j.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {
    @Test
    public void whenAnalizeCkeck() {
        String source = "sourse.txt";
        String target = "target.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        List<StringBuilder> result = new ArrayList<>();
        try (FileInputStream in = new FileInputStream("target.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);

            }
            result.add(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(
                "[[10:57:01, 10:59:01, 11:01:02, 11:02:02]]",
                is(result.toString())
        );
    }

}