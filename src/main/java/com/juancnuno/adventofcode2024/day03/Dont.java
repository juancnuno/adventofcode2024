package com.juancnuno.adventofcode2024.day03;

final class Dont extends Instruction {

    static final String STRING = "don't()";
    static final Instruction INSTANCE = new Dont();

    private Dont() {
    }

    @Override
    void execute(Program program) {
        program.setMulsEnabled(false);
    }
}
