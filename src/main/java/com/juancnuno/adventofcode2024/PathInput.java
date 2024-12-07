package com.juancnuno.adventofcode2024;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public final class PathInput extends Input {

    public static final Input INSTANCE = new PathInput();
    private static final Path INPUT = Path.of(System.getProperty("user.home"), "input.txt");

    private PathInput() {
    }

    @Override
    public List<String> lineList() {
        try {
            return Files.readAllLines(INPUT);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    @Override
    public Stream<String> lineStream() {
        try {
            return Files.lines(INPUT);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    @Override
    public String toString() {
        try {
            return Files.readString(INPUT);
        } catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }
}
