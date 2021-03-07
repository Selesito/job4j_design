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
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                String[] rsl = line.trim().split(" ");
                if (!check && (line.contains("500") || line.contains("400"))) {
                    result.add(rsl[1]);
                    check = true;
                } else if (check && (line.contains("200") || line.contains("300"))) {
                    result.add(rsl[1]);
                    check = false;
                }
            }
            try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
                out.write(result.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
