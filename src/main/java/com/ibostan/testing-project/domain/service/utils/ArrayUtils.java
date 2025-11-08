package com.ibostan.testingproject.domain.service.utils;

import java.util.Objects;
import java.util.Optional;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static Optional<Integer> findSquaredNumberIndex(int[] numbers, int targetSquaredValue) {
        Objects.requireNonNull(numbers, "Numbers array cannot be null");

        for (int arrayIndex = 0; arrayIndex < numbers.length; arrayIndex++) {
            int currentNumber = numbers[arrayIndex];
            double squaredValue = Math.pow(currentNumber, 2);

            if (squaredValue == targetSquaredValue) {
                return Optional.of(arrayIndex);
            }
        }

        return Optional.empty();
    }

    public static Optional<Integer> findSquaredNumberIndexFromIntegerArray(Integer[] numbers, Integer targetSquaredValue) {
        Objects.requireNonNull(numbers, "Numbers array cannot be null");
        Objects.requireNonNull(targetSquaredValue, "Target cannot be null");

        for (int arrayIndex = 0; arrayIndex < numbers.length; arrayIndex++) {
            Integer currentNumber = numbers[arrayIndex];

            if (Objects.nonNull(currentNumber)) {
                double squaredValue = Math.pow(currentNumber, 2);

                if (squaredValue == targetSquaredValue) {
                    return Optional.of(arrayIndex);
                }
            }
        }

        return Optional.empty();
    }

    public static Optional<Integer> findSquaredNumberIndexWithTolerance(double[] numbers, double targetSquaredValue, double tolerance) {
        Objects.requireNonNull(numbers, "Numbers array cannot be null");

        for (int arrayIndex = 0; arrayIndex < numbers.length; arrayIndex++) {
            double currentNumber = numbers[arrayIndex];
            double squaredValue = Math.pow(currentNumber, 2);
            double difference = Math.abs(squaredValue - targetSquaredValue);

            if (difference < tolerance) {
                return Optional.of(arrayIndex);
            }
        }

        return Optional.empty();
    }
}
