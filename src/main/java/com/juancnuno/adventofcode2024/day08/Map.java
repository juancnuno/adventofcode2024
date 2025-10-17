package com.juancnuno.adventofcode2024.day08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.juancnuno.adventofcode2024.Input;

public final class Map {

    private final Input input;

    public Map(Input input) {
        this.input = input;
    }

    public int getAntinodeCount() {
        return 0;
    }

    private java.util.Map<Character, Collection<Antenna>> getFrequencyToAntennaMultimap() {
        var list = input.lineList();
        var multimap = new HashMap<Character, Collection<Antenna>>();

        for (int y = 0, yMax = list.size(); y < yMax; y++) {
            var line = list.get(y);

            for (int x = 0, xMax = line.length(); x < xMax; x++) {
                var c = line.charAt(x);

                if (c == '.') {
                    continue;
                }

                multimap.computeIfAbsent(c, _ -> new ArrayList<>()).add(new Antenna(c, x, y));
            }
        }

        return multimap;
    }
}
