package com.juancnuno.adventofcode2024.test.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day01.Part1;
import com.juancnuno.adventofcode2024.test.StringInput;

final class Part1Test {

    @Test
    void getTotalDistance() {
        // Arrange
        var input = new StringInput("""
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
            """);

        // Act
        var distance = Part1.getTotalDistance(input);

        // Assert
        assertEquals(11, distance);
    }
}
