package com.juancnuno.adventofcode2024.day06;

import java.util.Collection;
import java.util.HashSet;

final class Guard {

    private Position position;
    private Orientation orientation;

    private final Map map;
    private final Collection<Position> visitedPositions;
    private final Collection<Obstruction> obstructions;

    Guard(Position position, Map map) {
        this.position = position;
        orientation = Orientation.UP;

        this.map = map;
        visitedPositions = new HashSet<>();
        obstructions = new HashSet<>();
    }

    Object move() {
        while (map.contains(position)) {
            switch (isObstructed()) {
                case OBSTRUCTED ->
                    turnRight();
                case OBSTRUCTED_MORE_THAN_ONCE -> {
                    return Loop.INSTANCE;
                }
                case NOT_OBSTRUCTED ->
                    stepForward();
            }
        }

        return visitedPositions.size();
    }

    private IsObstructedResult isObstructed() {
        if (map.hasObstructionAt(position.next(orientation))) {
            if (obstructions.add(new Obstruction(position, orientation))) {
                return IsObstructedResult.OBSTRUCTED;
            } else {
                return IsObstructedResult.OBSTRUCTED_MORE_THAN_ONCE;
            }
        } else {
            return IsObstructedResult.NOT_OBSTRUCTED;
        }
    }

    private void turnRight() {
        orientation = orientation.right();
    }

    private void stepForward() {
        visitedPositions.add(position);
        position = position.next(orientation);
    }

    Position getPosition() {
        return position;
    }
}
