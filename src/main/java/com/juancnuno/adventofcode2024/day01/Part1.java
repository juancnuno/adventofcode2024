package com.juancnuno.adventofcode2024.day01;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part1 {

    private Part1() {
    }

    public static int getTotalDistance(Input input) {
        var pattern = Pattern.compile(" +");
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();

        try (var lines = input.lineStream()) {
            lines.forEach(line -> {
                var ids = pattern.split(line);

                list1.add(Integer.valueOf(ids[0]));
                list2.add(Integer.valueOf(ids[1]));
            });
        }

        list1.sort(null);
        list2.sort(null);

        var totalDistance = 0;

        while (!list1.isEmpty()) {
            totalDistance += Math.abs(list1.removeFirst() - list2.removeFirst());
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        System.out.println(getTotalDistance(PathInput.INSTANCE));
    }
}
