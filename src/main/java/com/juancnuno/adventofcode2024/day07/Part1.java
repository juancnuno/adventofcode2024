package com.juancnuno.adventofcode2024.day07;

import java.util.List;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part1 {

    private Part1() {
    }

    public static long getTotalCalibrationResult(Input input) {
        return Equation.getTotalCalibrationResult(input, List.of(Equation::add, Equation::multiply));
    }

    public static void main(String[] args) {
        System.out.println(getTotalCalibrationResult(PathInput.INSTANCE));
    }
}
