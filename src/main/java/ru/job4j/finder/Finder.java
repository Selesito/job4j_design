package ru.job4j.finder;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Finder {
    public static List<Path> search(Path path, String pred, String type) throws IOException {
        Search.SearchFiles searcher = null;
        if (type.equals("mask")) {
            searcher = new Search.SearchFiles(p -> p.toFile().getName().endsWith(pred));
        } else if (type.equals("name")) {
            searcher = new Search.SearchFiles(p -> p.toFile().getName().equals(pred));
        }
        Files.walkFileTree(path, searcher);
        return searcher.getPath();
    }

    public void write(List<Path> value, String target) {
        try (PrintWriter out = new PrintWriter(new FileWriter(target))) {
            for (Path log : value) {
                out.println(log.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FinderValid valid = new FinderValid(args);
        if (!valid.isValid()) {
            throw new IllegalArgumentException("Check is correct that -not are the "
                    + "null parameters passed and"
                    + " -d=c:/ -n=*.txt -t=mask -o=log.txt");
        }
        ArgsName name = ArgsName.of(args);
        List<Path> result = search(Path.of(name.get("d")), name.get("n"), name.get("t"));
        new Finder().write(result, name.get("o"));
    }
}
