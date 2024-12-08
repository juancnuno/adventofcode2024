package com.juancnuno.adventofcode2024.day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part1 {

    private final Input input;
    private final Collection<Update> updates;
    private final Map<Integer, Collection<Integer>> multimap;

    public Part1(Input input) {
        this.input = input;

        updates = new ArrayList<>();
        multimap = new HashMap<>();
    }

    public int getMiddlePageSum() {
        try (var lines = input.lineStream()) {
            lines.forEach(line -> {
                if (line.indexOf('|') != -1) {
                    addRule(line);
                } else if (line.equals("")) {
                } else if (line.indexOf(',') != -1) {
                    updates.add(new Update(line));
                } else {
                    assert false : line;
                }
            });
        }

        return updates.stream()
                .filter(update -> update.isInRightOrder(multimap))
                .mapToInt(Update::getMiddlePage)
                .sum();
    }

    private void addRule(String rule) {
        var pages = rule.split("\\|");
        var page1 = Integer.parseInt(pages[0]);
        var page2 = Integer.parseInt(pages[1]);

        multimap.computeIfAbsent(page1, p1 -> new HashSet<>()).add(page2);
    }

    public static void main(String[] args) {
        System.out.println(new Part1(PathInput.INSTANCE).getMiddlePageSum());
    }
}
