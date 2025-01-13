package com.juancnuno.adventofcode2024.test.day07;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day07.Part2;
import com.juancnuno.adventofcode2024.test.StringInput;

final class Part2Test {

    @Test
    void getTotalCalibrationResult() {
        // Arrange
        var input = new StringInput("""
            190: 10 19
            3267: 81 40 27
            83: 17 5
            156: 15 6
            7290: 6 8 6 15
            161011: 16 10 13
            192: 17 8 14
            21037: 9 7 18 13
            292: 11 6 16 20
            """);

        // Act
        var result = Part2.getTotalCalibrationResult(input);

        // Assert
        assertEquals(11_387, result);
    }
}
