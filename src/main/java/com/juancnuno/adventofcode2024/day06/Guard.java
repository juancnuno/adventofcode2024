package com.juancnuno.adventofcode2024.day06;

import java.util.Collection;
import java.util.HashSet;

final class Guard {

    private Position position;
    private Orientation orientation;

    private final Map map;
    private final Collection<Position> visitedPositions;

    Guard(Position position, Map map) {
        this.position = position;
        orientation = Orientation.UP;
        this.map = map;
        visitedPositions = new HashSet<>();
    }

    int move() {
        while (map.contains(position)) {
            if (isBlocked()) {
                turnRight();
            } else {
                stepForward();
            }
        }

        return visitedPositions.size();
    }

    private boolean isBlocked() {
        return map.hasObstructionAt(position.next(orientation));
    }

    private void turnRight() {
        orientation = orientation.right();
    }

    private void stepForward() {
        visitedPositions.add(position);
        position = position.next(orientation);
    }
}
