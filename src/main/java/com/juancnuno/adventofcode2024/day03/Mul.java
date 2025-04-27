package com.juancnuno.adventofcode2024.day03;

import java.util.regex.MatchResult;

// TODO This should be declared with package access
public record Mul(int x, int y) implements Instruction {

    Mul(MatchResult result) {
        this(Integer.parseInt(result.group(1)), Integer.parseInt(result.group(2)));
    }
}
