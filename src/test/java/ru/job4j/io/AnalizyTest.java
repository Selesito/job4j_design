package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

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
                result.toString(),
                is("[10:57:01 - 10:59:01;" + System.lineSeparator()
                        + "11:01:02 - 11:02:02;" + System.lineSeparator() + "]")
        );
    }

    @Test
    public void whenAnalizeTemporaryFolder() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("300 10:59:01");
        }

        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat(rsl.toString(), is("10:57:01 - 10:59:01;"));
    }
}