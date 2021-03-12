package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Search {

    public static List<Path> search(Path path, String pred) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(pred));
        Files.walkFileTree(path, searcher);
        return searcher.getPath();
    }

    private static class SearchFiles implements FileVisitor<Path> {
        private final Predicate<Path> predicate;
        private final List<Path> path;

        public SearchFiles(Predicate<Path> predicate) {
            this.predicate = predicate;
            this.path = new ArrayList<>();
        }

        public List<Path> getPath() {
            return path;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (predicate.test(file)) {
                path.add(file);
            }
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java"
                    + " -jar dir.jar ROOT_FOLDER.");
        }
        search(Path.of(args[0]), "java");
    }
}