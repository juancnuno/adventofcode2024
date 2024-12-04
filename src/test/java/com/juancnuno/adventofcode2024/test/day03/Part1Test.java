package com.juancnuno.adventofcode2024.test.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day03.Part1;
import com.juancnuno.adventofcode2024.test.StringInput;

final class Part1Test {

    @Test
    void getResultSum() {
        // Arrange
        var input = new StringInput("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");

        // Act
        var sum = Part1.getResultSum(input);

        // Assert
        assertEquals(161, sum);
    }
}
