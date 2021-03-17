package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        for (File source : sources) {
            packSingleFile(source, target);
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        if (!argZip.valid()) {
            throw new IllegalArgumentException("There must be 3 parameters!");
        }
        List<Path> path = Search.search(Path.of(argZip.directory()), argZip.exclude());
        List<File> files = new ArrayList();
        for (Path rsl : path) {
            files.add(rsl.toFile());
        }
        new Zip().packFiles(files, new File("./" + argZip.output()));
    }
}
