package com.juancnuno.adventofcode2024.day03;

final class Do extends Instruction {

    static final String STRING = "do()";
    static final Instruction INSTANCE = new Do();

    private Do() {
    }

    @Override
    void execute(Program program) {
        program.setMulsEnabled(true);
    }
}
