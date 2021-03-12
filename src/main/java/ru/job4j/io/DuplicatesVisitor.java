package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> duplicate;

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String name = file.getFileName().toString();
        long size = file.toFile().length();
        FileProperty fileCurr = new FileProperty(size, name);
        if (!duplicate.add(fileCurr)) {
            System.out.println("File is duplicates");
        }
        return super.visitFile(file, attrs);
    }
}