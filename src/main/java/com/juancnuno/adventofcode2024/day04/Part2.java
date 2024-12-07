package com.juancnuno.adventofcode2024.day04;

import com.juancnuno.adventofcode2024.PathInput;

final class Part2 {

    private Part2() {
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch(PathInput.INSTANCE).getXMasCount());
    }
}
