package com.juancnuno.adventofcode2024.day07;

import java.util.List;
import java.util.function.LongBinaryOperator;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part2 {

    private Part2() {
    }

    public static long getTotalCalibrationResult(Input input) {
        var operators = List.<LongBinaryOperator>of(Equation::add, Equation::multiply, Equation::concat);

        return input.lineStream()
                .map(Equation::new)
                .filter(equation -> equation.canBeTrue(operators))
                .mapToLong(Equation::getTestValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(getTotalCalibrationResult(PathInput.INSTANCE));
    }
}
