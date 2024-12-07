package com.juancnuno.adventofcode2024.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import com.juancnuno.adventofcode2024.Input;

public final class WordSearch {

    private static final Pattern XMAS = Pattern.compile("XMAS");
    private static final Pattern SAMX = Pattern.compile("SAMX");

    private List<String> rows;
    private final Input input;

    public WordSearch(Input input) {
        this.input = input;
    }

    public int getCount() {
        rows = input.lineList();

        var iterators = new ArrayList<Object>();
        var columnCount = getColumnCount();
        var lastColumnIndex = columnCount - 1;

        IntStream.range(0, getRowCount()).forEach(rowIndex -> {
            iterators.add(new WordSearchIterator(rowIndex, 0, this, Direction.EAST));
            iterators.add(new WordSearchIterator(rowIndex, 0, this, Direction.SOUTHEAST));
            iterators.add(new WordSearchIterator(rowIndex, lastColumnIndex, this, Direction.SOUTHWEST));
        });

        IntStream.range(0, columnCount).forEach(columnIndex -> {
            iterators.add(new WordSearchIterator(0, columnIndex, this, Direction.SOUTH));

            if (columnIndex != 0) {
                iterators.add(new WordSearchIterator(0, columnIndex, this, Direction.SOUTHEAST));
            }

            if (columnIndex != lastColumnIndex) {
                iterators.add(new WordSearchIterator(0, columnIndex, this, Direction.SOUTHWEST));
            }
        });

        return iterators.stream()
                .map(Object::toString)
                .mapToInt(WordSearch::getMatchCount)
                .sum();
    }

    private static int getMatchCount(CharSequence sequence) {
        return WordSearch.getMatchCount(XMAS.matcher(sequence)) + WordSearch.getMatchCount(SAMX.matcher(sequence));
    }

    private static int getMatchCount(Matcher matcher) {
        var count = 0;

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    int getRowCount() {
        return rows.size();
    }

    int getColumnCount() {
        return rows.getFirst().length();
    }

    char charAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).charAt(columnIndex);
    }
}
