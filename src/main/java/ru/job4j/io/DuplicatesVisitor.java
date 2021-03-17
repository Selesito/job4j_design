package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<FileProperty> noDuplicate = new HashSet<>();
    private List<FileProperty> duplicate = new ArrayList<>();

    public Set<FileProperty> getNoDuplicate() {
        return noDuplicate;
    }

    public List<FileProperty> getDuplicate() {
        return duplicate;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String name = file.getFileName().toString();
        long size = file.toFile().length();
        FileProperty fileCurr = new FileProperty(size, name);
        if (!noDuplicate.add(fileCurr)) {
            duplicate.add(fileCurr);
            System.out.println("File is duplicates");
        }
        return super.visitFile(file, attrs);
    }
}