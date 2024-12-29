package com.juancnuno.adventofcode2024.day06;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.juancnuno.adventofcode2024.Input;

public final class Map {

    private final Collection<Position> obstructions;
    private Guard guard;

    private int maxX;
    private int maxY;

    private int x;
    private int y;

    public Map(Input input) {
        obstructions = new HashSet<>();

        try (var lines = input.lineStream()) {
            lines.forEach(this::handle);
        }

        obstructions.forEach(obstruction -> {
            maxX = Math.max(maxX, obstruction.x());
            maxY = Math.max(maxY, obstruction.y());
        });
    }

    private Map(Collection<Position> obstructions) {
        this.obstructions = obstructions;

        obstructions.forEach(obstruction -> {
            maxX = Math.max(maxX, obstruction.x());
            maxY = Math.max(maxY, obstruction.y());
        });
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

    public int getPositionCount() {
        return (int) guard.move();
    }

    public int getLoopCount() {
        return (int) IntStream.rangeClosed(0, maxX)
                .boxed()
                .flatMap(this::positions)
                .filter(Predicate.not(this::hasObstructionAt))
                .filter(Predicate.not(this::hasGuardAt))
                .map(this::newMap)
                .map(map -> map.guard.move())
                .filter(result -> result.equals(Loop.INSTANCE))
                .count();
    }

    private Stream<Position> positions(int x) {
        return IntStream.rangeClosed(0, maxY).mapToObj(y2 -> new Position(x, y2));
    }

    private Map newMap(Position obstruction) {
        var newObstructions = new HashSet<>(obstructions);
        newObstructions.add(obstruction);

        var map = new Map(newObstructions);
        map.guard = new Guard(guard.getPosition(), map);

        return map;
    }

    boolean contains(Position position) {
        var positionX = position.x();
        var positionY = position.y();

        return 0 <= positionX && positionX <= maxX && 0 <= positionY && positionY <= maxY;
    }

    boolean hasObstructionAt(Position positiion) {
        return obstructions.contains(positiion);
    }

    private boolean hasGuardAt(Position position) {
        return guard.getPosition().equals(position);
    }
}
