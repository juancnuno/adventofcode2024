package com.juancnuno.adventofcode2024.day06;

record Position(int x, int y) {

    Position next(Orientation orientation) {
        return switch (orientation) {
            case UP ->
                new Position(x - 1, y);
            case RIGHT ->
                new Position(x, y + 1);
            case DOWN ->
                new Position(x + 1, y);
            case LEFT ->
                new Position(x, y - 1);
        };
    }
}
