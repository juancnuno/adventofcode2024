package com.juancnuno.adventofcode2024.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public final class Report {

    private final List<Integer> levels;

    public Report(String levels) {
        this.levels = Arrays.stream(levels.split(" "))
                .map(Integer::valueOf)
                .toList();
    }

    private Report(List<Integer> levels) {
        this.levels = levels;
    }

    public boolean isSafeWithDampener() {
        if (isSafe()) {
            return true;
        }

        return IntStream.range(0, levels.size())
                .mapToObj(this::remove)
                .anyMatch(Report::isSafe);
    }

    private Report remove(int index) {
        var copy = new ArrayList<>(levels);
        copy.remove(index);

        return new Report(copy);
    }

    public boolean isSafe() {
        return IntStream.range(1, levels.size()).allMatch(this::areLevelsIncreasingGradually)
                || IntStream.range(1, levels.size()).allMatch(this::areLevelsDecreasingGradually);
    }

    private boolean areLevelsIncreasingGradually(int index) {
        var previousLevel = levels.get(index - 1);
        var level = levels.get(index);

        return previousLevel < level && level - previousLevel <= 3;
    }

    private boolean areLevelsDecreasingGradually(int index) {
        var previousLevel = levels.get(index - 1);
        var level = levels.get(index);

        return previousLevel > level && previousLevel - level <= 3;
    }
}
