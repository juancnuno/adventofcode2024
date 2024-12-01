package com.juancnuno.adventofcode2024.day01;

import java.util.stream.Stream;

public final class StringInput extends Input {

    private final String input;

    public StringInput(String input) {
        this.input = input;
    }

    @Override
    Stream<String> lines() {
        return input.lines();
    }
}
