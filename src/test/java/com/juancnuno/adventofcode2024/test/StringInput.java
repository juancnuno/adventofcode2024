package com.juancnuno.adventofcode2024.test;

import java.util.stream.Stream;

import com.juancnuno.adventofcode2024.Input;

public final class StringInput extends Input {

    private final String input;

    public StringInput(String input) {
        this.input = input;
    }

    @Override
    public Stream<String> lines() {
        return input.lines();
    }

    @Override
    public String toString() {
        return input;
    }
}
