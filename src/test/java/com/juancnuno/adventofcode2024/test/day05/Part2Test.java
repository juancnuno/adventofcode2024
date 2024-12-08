package com.juancnuno.adventofcode2024.test.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day05.Part2;
import com.juancnuno.adventofcode2024.test.StringInput;

final class Part2Test {

    @Test
    void getMiddlePageSum() {
        // Arrange
        var part2 = new Part2(new StringInput("""
            47|53
            97|13
            97|61
            97|47
            75|29
            61|13
            75|53
            29|13
            97|29
            53|29
            61|53
            97|53
            61|29
            47|13
            75|47
            97|75
            47|61
            75|61
            47|29
            75|13
            53|13

            75,47,61,53,29
            97,61,53,29,13
            75,29,13
            75,97,47,61,53
            61,13,29
            97,13,75,29,47
            """));

        // Act
        var sum = part2.getMiddlePageSum();

        // Assert
        assertEquals(123, sum);
    }
}
