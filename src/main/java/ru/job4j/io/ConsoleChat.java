package ru.job4j.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String message = in.nextLine();
        List<String> logs = new ArrayList<>();
        logs.add(message);
        List<String> reading = read();
        boolean result = false;
        String bot = "";
        while (!message.equals(OUT)) {
            if (result) {
                message = in.nextLine();
                logs.add(message);
                if (message.equals(CONTINUE)) {
                    result = false;
                }
            } else {
                bot = reading.get((int) (Math.random() * reading.size()));
                System.out.println(bot);
                logs.add(bot);
                message = in.nextLine();
                logs.add(message);
                if (message.equals(STOP)) {
                    result = true;
                }
            }
        }
        write(logs.toString());
    }

    private List<String> read() {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(this.botAnswers))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] result = line.split(" ");
                for (String value : result) {
                    rsl.add(value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private void write(String value) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(this.path))) {
            out.write(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat(args[0], args[1]);
        cc.run();
    }
}