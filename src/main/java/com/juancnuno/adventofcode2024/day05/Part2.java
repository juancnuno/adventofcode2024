package com.juancnuno.adventofcode2024.day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part2 {

    private final Input input;
    private final PageComparator comparator;
    private final Collection<Update> updates;

    public Part2(Input input) {
        this.input = input;

        comparator = new PageComparator();
        updates = new ArrayList<>();
    }

    public int getMiddlePageSum() {
        try (var lines = input.lineStream()) {
            lines.forEach(line -> {
                if (line.indexOf('|') != -1) {
                    comparator.addRule(line);
                } else if (line.equals("")) {
                } else if (line.indexOf(',') != -1) {
                    updates.add(new Update(line, comparator));
                } else {
                    assert false : line;
                }
            });
        }

        return updates.stream()
                .filter(Predicate.not(Update::isInRightOrder))
                .map(Update::sortPages)
                .mapToInt(Update::getMiddlePage)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new Part2(PathInput.INSTANCE).getMiddlePageSum());
    }
}
