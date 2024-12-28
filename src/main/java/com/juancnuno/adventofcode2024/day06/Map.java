package com.juancnuno.adventofcode2024.day06;

import java.util.Collection;
import java.util.HashSet;

import com.juancnuno.adventofcode2024.Input;

public final class Map {

    private final Input input;

    private final Collection<Position> obstructions;
    private Guard guard;

    private int maxX;
    private int maxY;

    private int x;
    private int y;

    public Map(Input input) {
        this.input = input;
        obstructions = new HashSet<>();
    }

    public int getPositionCount() {
        try (var lines = input.lineStream()) {
            lines.forEach(this::handle);
        }

        obstructions.forEach(obstruction -> {
            maxX = Math.max(maxX, obstruction.x());
            maxY = Math.max(maxY, obstruction.y());
        });

        return guard.move();
    }

    private void handle(CharSequence line) {
        y = 0;
        line.chars().forEach(this::handle);
        x++;
    }

    private void handle(int c) {
        switch (c) {
            case '#' ->
                obstructions.add(new Position(x, y));
            case '^' ->
                guard = new Guard(new Position(x, y), this);
            default -> {
            }
        }

        y++;
    }

    boolean contains(Position position) {
        var positionX = position.x();
        var positionY = position.y();

        return 0 <= positionX && positionX <= maxX && 0 <= positionY && positionY <= maxY;
    }

    boolean hasObstructionAt(Position positiion) {
        return obstructions.contains(positiion);
    }
}
