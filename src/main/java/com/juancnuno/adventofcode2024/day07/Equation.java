package com.juancnuno.adventofcode2024.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.LongBinaryOperator;

final class Equation {

    private final long testValue;
    private final List<Object> objects;

    Equation(String equation) {
        var testValueAndNumbers = equation.split(": ");
        testValue = Long.parseLong(testValueAndNumbers[0]);

        objects = Arrays.stream(testValueAndNumbers[1].split(" "))
                .map(Long::valueOf)
                .map(Object.class::cast)
                .toList();
    }

    private Equation(long testValue, long number) {
        this.testValue = testValue;
        objects = List.of(number);
    }

    private Equation(Equation equation, LongBinaryOperator operator, long number) {
        testValue = equation.testValue;

        objects = new ArrayList<>(equation.objects);
        objects.addAll(List.of(operator, number));
    }

    boolean canBeTrue() {
        return insertOperators().stream()
                .map(Equation::evaluate)
                .anyMatch(value -> value == testValue);
    }

    private Collection<Equation> insertOperators() {
        return insertOperators(new ArrayList<>(), new Equation(testValue, (long) objects.getFirst()), objects.subList(1, objects.size()));
    }

    private static Collection<Equation> insertOperators(Collection<Equation> equations, Equation equation, List<Object> numbers) {
        if (numbers.isEmpty()) {
            equations.add(equation);
        } else {
            var number = (long) numbers.getFirst();
            var sublist = numbers.subList(1, numbers.size());

            insertOperators(equations, new Equation(equation, (number1, number2) -> number1 + number2, number), sublist);
            insertOperators(equations, new Equation(equation, (number1, number2) -> number1 * number2, number), sublist);
        }

        return equations;
    }

    private long evaluate() {
        while (objects.size() != 1) {
            var number1 = (long) objects.removeFirst();
            var operator = (LongBinaryOperator) objects.removeFirst();
            var number2 = (long) objects.removeFirst();

            objects.addFirst(operator.applyAsLong(number1, number2));
        }

        return (long) objects.getFirst();
    }

    long getTestValue() {
        return testValue;
    }
}
