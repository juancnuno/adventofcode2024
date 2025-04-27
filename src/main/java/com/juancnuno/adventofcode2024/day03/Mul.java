package com.juancnuno.adventofcode2024.day03;

import java.util.regex.MatchResult;

final class Mul implements Instruction {

    private final int x;
    private final int y;

    Mul(MatchResult result) {
        x = Integer.parseInt(result.group(1));
        y = Integer.parseInt(result.group(2));
    }

    int getProduct() {
        return x * y;
    }
}
