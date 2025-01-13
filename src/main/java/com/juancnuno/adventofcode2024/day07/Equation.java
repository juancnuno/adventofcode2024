package com.juancnuno.adventofcode2024.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.LongBinaryOperator;

final class Equation {

    private final long testValue;
    private final List<Long> numbers;

    Equation(String equation) {
        var testValueAndNumbers = equation.split(": ");
        testValue = Long.parseLong(testValueAndNumbers[0]);

        numbers = Arrays.stream(testValueAndNumbers[1].split(" "))
                .map(Long::valueOf)
                .toList();
    }

    static long add(long number1, long number2) {
        return number1 + number2;
    }

    static long multiply(long number1, long number2) {
        return number1 * number2;
    }

    static long concat(long number1, long number2) {
        return Long.parseLong(Long.toString(number1) + Long.toString(number2));
    }

    boolean canBeTrue(Iterable<LongBinaryOperator> operators) {
        var testValues = new ArrayList<Long>();
        evaluate(1, operators, numbers.getFirst(), testValues);

        return testValues.contains(testValue);
    }

    private void evaluate(int i, Iterable<LongBinaryOperator> operators, long testValue, Collection<Long> testValues) {
        if (i < numbers.size()) {
            var number = numbers.get(i);
            operators.forEach(operator -> evaluate(i + 1, operators, operator.applyAsLong(testValue, number), testValues));
        } else {
            testValues.add(testValue);
        }
    }

    long getTestValue() {
        return testValue;
    }
}
