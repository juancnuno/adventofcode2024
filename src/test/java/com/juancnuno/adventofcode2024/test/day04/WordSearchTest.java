package com.juancnuno.adventofcode2024.test.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.juancnuno.adventofcode2024.day04.WordSearch;
import com.juancnuno.adventofcode2024.test.StringInput;

final class WordSearchTest {

    @Test
    void getCount1() {
        // Arrange
        var search = new WordSearch(new StringInput("""
            ..X...
            .SAMX.
            .A..A.
            XMAS.S
            .X....
            """));

        // Act
        var count = search.getCount();

        // Assert
        assertEquals(4, count);
    }

    @Test
    void getCount2() {
        // Arrange
        var search = new WordSearch(new StringInput("""
            MMMSXXMASM
            MSAMXMSMSA
            AMXSXMAAMM
            MSAMASMSMX
            XMASAMXAMM
            XXAMMXXAMA
            SMSMSASXSS
            SAXAMASAAA
            MAMMMXMMMM
            MXMXAXMASX
            """));

        // Act
        var count = search.getCount();

        // Assert
        assertEquals(18, count);
    }

    @Test
    void getCount3() {
        // Arrange
        var search = new WordSearch(new StringInput("""
            ....XXMAS.
            .SAMXMS...
            ...S..A...
            ..A.A.MS.X
            XMASAMX.MM
            X.....XA.A
            S.S.S.S.SS
            .A.A.A.A.A
            ..M.M.M.MM
            .X.X.XMASX
            """));

        // Act
        var count = search.getCount();

        // Assert
        assertEquals(18, count);
    }

    @Test
    void getXMasCount1() {
        // Arrange
        var search = new WordSearch(new StringInput("""
            M.S
            .A.
            M.S
            """));

        // Act
        var count = search.getXMasCount();

        // Assert
        assertEquals(1, count);
    }

    @Test
    void getXMasCount2() {
        // Arrange
        var search = new WordSearch(new StringInput("""
            .M.S......
            ..A..MSMS.
            .M.S.MAA..
            ..A.ASMSM.
            .M.S.M....
            ..........
            S.S.S.S.S.
            .A.A.A.A..
            M.M.M.M.M.
            ..........
            """));

        // Act
        var count = search.getXMasCount();

        // Assert
        assertEquals(9, count);
    }
}
