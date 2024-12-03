package com.juancnuno.adventofcode2024.day01;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.juancnuno.adventofcode2024.Input;
import com.juancnuno.adventofcode2024.PathInput;

public final class Part2 {

    private Part2() {
    }

    public static long getSimilarityScore(Input input) {
        var pattern = Pattern.compile(" +");
        var list1 = new ArrayList<Integer>();
        var list2 = new ArrayList<Integer>();

        try (var lines = input.lines()) {
            lines.forEach(line -> {
                var ids = pattern.split(line);

                list1.add(Integer.valueOf(ids[0]));
                list2.add(Integer.valueOf(ids[1]));
            });
        }

        var map = list2.stream().collect(Collectors.groupingBy(id -> id, Collectors.counting()));

        return list1.stream()
                .mapToLong(id -> id * map.getOrDefault(id, 0L))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(getSimilarityScore(PathInput.INSTANCE));
    }
}
