package com.juancnuno.adventofcode2024.day06;

import com.juancnuno.adventofcode2024.PathInput;

final class Part2 {

    private Part2() {
    }

    public static void main(String[] args) {
        System.out.println(new Map(PathInput.INSTANCE).getLoopCount());
    }
}
