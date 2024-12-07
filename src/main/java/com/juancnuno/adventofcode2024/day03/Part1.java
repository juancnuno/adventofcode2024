package com.juancnuno.adventofcode2024.day03;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part1 {

    private Part1() {
    }

    public static int getResultSum(Input input) {
        var pattern = Pattern.compile("mul\\((\\d+),(\\d+)\\)");

        try (var lines = input.lineStream()) {
            return lines
                    .map(pattern::matcher)
                    .flatMap(Matcher::results)
                    .mapToInt(Part1::execute)
                    .sum();
        }
    }

    private static int execute(MatchResult instruction) {
        return Integer.parseInt(instruction.group(1)) * Integer.parseInt(instruction.group(2));
    }

    public static void main(String[] args) {
        System.out.println(getResultSum(PathInput.INSTANCE));
    }
}
