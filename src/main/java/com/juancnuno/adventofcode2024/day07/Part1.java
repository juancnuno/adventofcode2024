package com.juancnuno.adventofcode2024.day07;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part1 {

    private Part1() {
    }

    public static long getTotalCalibrationResult(Input input) {
        return input.lineStream()
                .map(Equation::new)
                .filter(Equation::canBeTrue)
                .mapToLong(Equation::getTestValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(getTotalCalibrationResult(PathInput.INSTANCE));
    }
}
