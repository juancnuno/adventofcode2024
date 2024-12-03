package com.juancnuno.adventofcode2024.day02;

import java.util.Arrays;
import java.util.List;

public final class Report {

    private final List<Integer> levels;

    public Report(String levels) {
        this.levels = Arrays.stream(levels.split(" "))
                .map(Integer::valueOf)
                .toList();
    }

    public boolean isSafe() {
        var firstLevel = levels.get(0);
        var secondLevel = levels.get(1);

        if (firstLevel.equals(secondLevel)) {
            return false;
        } else if (firstLevel < secondLevel) {
            return isSafeIncreasing();
        } else {
            return isSafeDecreasing();
        }
    }

    private boolean isSafeIncreasing() {
        for (int i = 1, size = levels.size(); i < size; i++) {
            var previousLevel = levels.get(i - 1);
            var level = levels.get(i);

            if (previousLevel >= level || !isDifferenceSafe(previousLevel, level)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSafeDecreasing() {
        for (int i = 1, size = levels.size(); i < size; i++) {
            var previousLevel = levels.get(i - 1);
            var level = levels.get(i);

            if (previousLevel <= level || !isDifferenceSafe(previousLevel, level)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDifferenceSafe(int previousLevel, int level) {
        var difference = Math.abs(level - previousLevel);
        return difference >= 1 && difference <= 3;
    }
}
