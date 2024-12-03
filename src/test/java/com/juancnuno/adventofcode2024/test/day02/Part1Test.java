package com.juancnuno.adventofcode2024.test.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day02.Part1;
import com.juancnuno.adventofcode2024.test.StringInput;

final class Part1Test {

    @Test
    void getSafeReportCount() {
        // Arrange
        var input = new StringInput("""
            7 6 4 2 1
            1 2 7 8 9
            9 7 6 2 1
            1 3 2 4 5
            8 6 4 4 1
            1 3 6 7 9
            """);

        // Act
        var count = Part1.getSafeReportCount(input);

        // Assert
        assertEquals(2, count);
    }
}
