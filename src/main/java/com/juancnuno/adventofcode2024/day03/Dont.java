package com.juancnuno.adventofcode2024.day03;

final class Dont implements Instruction {

    static final String STRING = "don't()";
    static final Instruction INSTANCE = new Dont();

    private Dont() {
    }
}
