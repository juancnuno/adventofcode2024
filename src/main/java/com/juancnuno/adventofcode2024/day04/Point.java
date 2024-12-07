package com.juancnuno.adventofcode2024.day04;

final class Point {

    private final int rowIndex;
    private final int columnIndex;
    private final WordSearch search;

    Point(int rowIndex, int columnIndex, WordSearch search) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.search = search;
    }

    boolean isXMas() {
        return isMas(getSoutheastWord()) && isMas(getSouthwestWord());
    }

    private static boolean isMas(Object i) {
        return i.equals("MAS") || i.equals("SAM");
    }

    private Object getSoutheastWord() {
        var builder = new StringBuilder(3);

        builder.append(search.charAt(rowIndex - 1, columnIndex - 1));
        builder.append(search.charAt(rowIndex, columnIndex));
        builder.append(search.charAt(rowIndex + 1, columnIndex + 1));

        return builder.toString();
    }

    private Object getSouthwestWord() {
        var builder = new StringBuilder(3);

        builder.append(search.charAt(rowIndex - 1, columnIndex + 1));
        builder.append(search.charAt(rowIndex, columnIndex));
        builder.append(search.charAt(rowIndex + 1, columnIndex - 1));

        return builder.toString();
    }
}
