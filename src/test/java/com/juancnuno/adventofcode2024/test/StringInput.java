package com.juancnuno.adventofcode2024.test;

import java.util.List;
import java.util.stream.Stream;

import com.juancnuno.adventofcode2024.Input;

public final class StringInput extends Input {

    private final String input;

    public StringInput(String input) {
        this.input = input;
    }

    @Override
    public List<String> lineList() {
        return input.lines().toList();
    }

    @Override
    public Stream<String> lineStream() {
        return input.lines();
    }
}
