package com.juancnuno.adventofcode2024.test.day02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day02.Report;

final class ReportTest {

    @Test
    void isSafe1() {
        // Arrange
        var report = new Report("7 6 4 2 1");

        // Act
        var safe = report.isSafe();

        // Assert
        assertTrue(safe);
    }

    @Test
    void isSafe2() {
        // Arrange
        var report = new Report("1 2 7 8 9");

        // Act
        var safe = report.isSafe();

        // Assert
        assertFalse(safe);
    }

    @Test
    void isSafe3() {
        // Arrange
        var report = new Report("9 7 6 2 1");

        // Act
        var safe = report.isSafe();

        // Assert
        assertFalse(safe);
    }

    @Test
    void isSafe4() {
        // Arrange
        var report = new Report("1 3 2 4 5");

        // Act
        var safe = report.isSafe();

        // Assert
        assertFalse(safe);
    }

    @Test
    void isSafe5() {
        // Arrange
        var report = new Report("8 6 4 4 1");

        // Act
        var safe = report.isSafe();

        // Assert
        assertFalse(safe);
    }

    @Test
    void isSafe6() {
        // Arrange
        var report = new Report("1 3 6 7 9");

        // Act
        var safe = report.isSafe();

        // Assert
        assertTrue(safe);
    }
}
