package com.juancnuno.adventofcode2024.test.day05;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.day05.PageComparator;
import com.juancnuno.adventofcode2024.test.StringInput;

final class PageComparatorTest {

    private static final Input INPUT = new StringInput("""
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
        """);

    private final PageComparator comparator;

    @SuppressWarnings("unused")
    private PageComparatorTest() {
        comparator = new PageComparator();
        INPUT.lineStream().forEach(comparator::addRule);
    }

    @Test
    void compareTo1() {
        // Arrange
        var pages = new ArrayList<>(List.of(75, 97, 47, 61, 53));

        // Act
        pages.sort(comparator);

        // Assert
        assertEquals(List.of(97, 75, 47, 61, 53), pages);
    }

    @Test
    void compareTo2() {
        // Arrange
        var pages = new ArrayList<>(List.of(61, 13, 29));

        // Act
        pages.sort(comparator);

        // Assert
        assertEquals(List.of(61, 29, 13), pages);
    }

    @Test
    void compareTo3() {
        // Arrange
        var pages = new ArrayList<>(List.of(97, 13, 75, 29, 47));

        // Act
        pages.sort(comparator);

        // Assert
        assertEquals(List.of(97, 75, 47, 29, 13), pages);
    }
}
