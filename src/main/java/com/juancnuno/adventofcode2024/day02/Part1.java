package com.juancnuno.adventofcode2024.day02;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part1 {

    private Part1() {
    }

    public static long getSafeReportCount(Input input) {
        return input.lines()
                .map(Report::new)
                .filter(Report::isSafe)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(getSafeReportCount(PathInput.INSTANCE));
    }
}
