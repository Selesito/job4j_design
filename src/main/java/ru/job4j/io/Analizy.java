package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        boolean check = false;
        List<String> result = new ArrayList<String>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                String[] rsl = line.trim().split(" ");
                if (!check && (line.contains("500") || line.contains("400"))) {
                    out.print(rsl[1] + " - ");
                    check = true;
                } else if (check && (line.contains("200") || line.contains("300"))) {
                    out.println(rsl[1] + ";");
                    check = false;
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
