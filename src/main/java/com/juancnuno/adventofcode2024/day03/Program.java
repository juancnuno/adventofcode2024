package com.juancnuno.adventofcode2024.day03;

public final class Program {

    private final Object input;

    private boolean mulsEnabled;
    private int sum;

    public Program(Object input) {
        this.input = input;
        mulsEnabled = true;
    }

    public int execute() {
        Instruction.instructions(input).forEach(instruction -> instruction.execute(this));
        return sum;
    }

    void setMulsEnabled(boolean mulsEnabled) {
        this.mulsEnabled = mulsEnabled;
    }

    void add(int result) {
        if (mulsEnabled) {
            sum += result;
        }
    }
}
