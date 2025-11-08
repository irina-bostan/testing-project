package com.ibostan.testingproject.domain.service.utils;

import java.util.Optional;

/**
 * Utility class for array operations
 */
public class ArrayUtils {

    private ArrayUtils() {
        // Private constructor to prevent instantiation
    }

    /**
     * Finds the index of a number in the array that, when squared, equals the target value.
     *
     * @param numbers the array of numbers to search
     * @param target the target value to match (should be the square of a number in the array)
     * @return an Optional containing the index of the number whose square equals the target,
     *         or an empty Optional if no such number is found
     * @throws IllegalArgumentException if the numbers array is null
     */
    public static Optional<Integer> findSquaredNumberIndex(int[] numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers array cannot be null");
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] * numbers[i] == target) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }

    /**
     * Finds the index of a number in the array that, when squared, equals the target value.
     * This variant works with Integer arrays instead of primitive int arrays.
     *
     * @param numbers the array of numbers to search
     * @param target the target value to match (should be the square of a number in the array)
     * @return an Optional containing the index of the number whose square equals the target,
     *         or an empty Optional if no such number is found
     * @throws IllegalArgumentException if the numbers array is null
     */
    public static Optional<Integer> findSquaredNumberIndex(Integer[] numbers, Integer target) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers array cannot be null");
        }

        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null");
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != null && numbers[i] * numbers[i] == target) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }

    /**
     * Finds the index of a number in the array that, when squared, equals the target value.
     * This variant works with double arrays for floating-point numbers.
     *
     * @param numbers the array of numbers to search
     * @param target the target value to match (should be the square of a number in the array)
     * @param epsilon the tolerance for floating-point comparison
     * @return an Optional containing the index of the number whose square equals the target,
     *         or an empty Optional if no such number is found
     * @throws IllegalArgumentException if the numbers array is null
     */
    public static Optional<Integer> findSquaredNumberIndex(double[] numbers, double target, double epsilon) {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers array cannot be null");
        }

        for (int i = 0; i < numbers.length; i++) {
            if (Math.abs(numbers[i] * numbers[i] - target) < epsilon) {
                return Optional.of(i);
            }
        }

        return Optional.empty();
    }
}
