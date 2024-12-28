package com.juancnuno.adventofcode2024.test.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day06.Map;
import com.juancnuno.adventofcode2024.test.StringInput;

final class MapTest {

    @Test
    void getPositionCount() {
        // Arrange
        var map = new Map(new StringInput("""
            ....#.....
            .........#
            ..........
            ..#.......
            .......#..
            ..........
            .#..^.....
            ........#.
            #.........
            ......#...
            """));

        // Act
        var count = map.getPositionCount();

        // Assert
        assertEquals(41, count);
    }
}
