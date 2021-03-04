package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            int rsl;
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    rsl = i * j;
                    out.write((rsl + "").getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
