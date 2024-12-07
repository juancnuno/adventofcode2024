package com.juancnuno.adventofcode2024.day04;

import com.juancnuno.adventofcode2024.PathInput;

final class Part1 {

    private Part1() {
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch(PathInput.INSTANCE).getCount());
    }
}
