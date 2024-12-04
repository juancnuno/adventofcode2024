package com.juancnuno.adventofcode2024.day03;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

abstract class Instruction {

    static Stream<Instruction> instructions(Object input) {
        return Pattern.compile("do\\(\\)|don't\\(\\)|mul\\((\\d+),(\\d+)\\)").matcher(input.toString()).results().map(Instruction::from);
    }

    private static Instruction from(MatchResult result) {
        return switch (result.group()) {
            case Do.STRING ->
                Do.INSTANCE;
            case Dont.STRING ->
                Dont.INSTANCE;
            default ->
                new Mul(result);
        };
    }

    abstract void execute(Program program);
}
