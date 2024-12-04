package com.juancnuno.adventofcode2024.test.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day03.Program;
import com.juancnuno.adventofcode2024.test.StringInput;

final class ProgramTest {

    @Test
    void execute() {
        // Arrange
        var program = new Program(new StringInput("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"));

        // Act
        var sum = program.execute();

        // Assert
        assertEquals(48, sum);
    }
}
