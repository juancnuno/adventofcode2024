package com.juancnuno.adventofcode2024.day04;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class WordSearchIterator implements Iterator<Character> {

    private int rowIndex;
    private int columnIndex;

    private final WordSearch search;
    private final Direction direction;

    WordSearchIterator(int rowIndex, int columnIndex, WordSearch search, Direction direction) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;

        this.search = search;
        this.direction = direction;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        while (hasNext()) {
            builder.append(next());
        }

        return builder.toString();
    }

    @Override
    public boolean hasNext() {
        return rowIndex < search.getRowCount() && 0 <= columnIndex && columnIndex < search.getColumnCount();
    }

    @Override
    public Character next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return switch (direction) {
            case SOUTH ->
                search.charAt(rowIndex++, columnIndex);
            case EAST ->
                search.charAt(rowIndex, columnIndex++);
            case SOUTHEAST ->
                search.charAt(rowIndex++, columnIndex++);
            case SOUTHWEST ->
                search.charAt(rowIndex++, columnIndex--);
        };
    }
}
