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
        Instruction.instructions(input).forEach(this::execute);
        return sum;
    }

    private void execute(Instruction instruction) {
        switch (instruction) {
            case Do _ ->
                mulsEnabled = true;
            case Dont _ ->
                mulsEnabled = false;
            case Mul mul -> {
                if (mulsEnabled) {
                    sum += mul.getProduct();
                }
            }
        }
    }
}
