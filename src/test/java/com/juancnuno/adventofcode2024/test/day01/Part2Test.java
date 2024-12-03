package com.juancnuno.adventofcode2024.test.day01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day01.Part2;
import com.juancnuno.adventofcode2024.test.StringInput;

final class Part2Test {

    @Test
    void getSimilarityScore() {
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
        var score = Part2.getSimilarityScore(input);

        // Assert
        assertEquals(31, score);
    }
}
