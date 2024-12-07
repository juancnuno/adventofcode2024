package com.juancnuno.adventofcode2024.day02;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part2 {

    private Part2() {
    }

    public static long getSafeReportCount(Input input) {
        try (var lines = input.lineStream()) {
            return lines
                    .map(Report::new)
                    .filter(Report::isSafeWithDampener)
                    .count();
        }
    }

    public static void main(String[] args) {
        System.out.println(getSafeReportCount(PathInput.INSTANCE));
    }
}
