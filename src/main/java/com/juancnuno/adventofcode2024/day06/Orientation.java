package com.juancnuno.adventofcode2024.day06;

enum Orientation {
    UP, RIGHT, DOWN, LEFT;

    Orientation right() {
        return switch (this) {
            case UP ->
                RIGHT;
            case RIGHT ->
                DOWN;
            case DOWN ->
                LEFT;
            case LEFT ->
                UP;
        };
    }
}
