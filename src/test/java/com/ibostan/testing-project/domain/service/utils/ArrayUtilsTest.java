package com.ibostan.testingproject.domain.service.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @Test
    @DisplayName("Should find index when squared number exists in primitive array")
    void testFindSquaredNumberIndex_PrimitiveArray_Found() {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 16; // 4^2 = 16

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertTrue(result.isPresent());
        assertEquals(3, result.get());
    }

    @Test
    @DisplayName("Should return empty when squared number doesn't exist in primitive array")
    void testFindSquaredNumberIndex_PrimitiveArray_NotFound() {
        int[] numbers = {1, 2, 3, 4, 5};
        int target = 20; // No number squares to 20

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Should handle negative numbers in primitive array")
    void testFindSquaredNumberIndex_PrimitiveArray_NegativeNumbers() {
        int[] numbers = {-5, -4, -3, 3, 4, 5};
        int target = 16; // Both -4 and 4 square to 16, should find first occurrence

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertTrue(result.isPresent());
        assertEquals(1, result.get()); // Should find -4 at index 1
    }

    @Test
    @DisplayName("Should find zero squared in primitive array")
    void testFindSquaredNumberIndex_PrimitiveArray_Zero() {
        int[] numbers = {1, 0, 3, 4, 5};
        int target = 0; // 0^2 = 0

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    @Test
    @DisplayName("Should handle empty primitive array")
    void testFindSquaredNumberIndex_PrimitiveArray_Empty() {
        int[] numbers = {};
        int target = 16;

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Should throw exception when primitive array is null")
    void testFindSquaredNumberIndex_PrimitiveArray_Null() {
        int[] numbers = null;
        int target = 16;

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.findSquaredNumberIndex(numbers, target);
        });
    }

    @Test
    @DisplayName("Should find index when squared number exists in Integer array")
    void testFindSquaredNumberIndex_IntegerArray_Found() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Integer target = 9; // 3^2 = 9

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertTrue(result.isPresent());
        assertEquals(2, result.get());
    }

    @Test
    @DisplayName("Should handle null elements in Integer array")
    void testFindSquaredNumberIndex_IntegerArray_NullElements() {
        Integer[] numbers = {1, null, 3, 4, 5};
        Integer target = 9;

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertTrue(result.isPresent());
        assertEquals(2, result.get());
    }

    @Test
    @DisplayName("Should throw exception when Integer array is null")
    void testFindSquaredNumberIndex_IntegerArray_Null() {
        Integer[] numbers = null;
        Integer target = 16;

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.findSquaredNumberIndex(numbers, target);
        });
    }

    @Test
    @DisplayName("Should throw exception when target is null in Integer array")
    void testFindSquaredNumberIndex_IntegerArray_NullTarget() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Integer target = null;

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.findSquaredNumberIndex(numbers, target);
        });
    }

    @Test
    @DisplayName("Should find index when squared number exists in double array")
    void testFindSquaredNumberIndex_DoubleArray_Found() {
        double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};
        double target = 16.0; // 4.0^2 = 16.0
        double epsilon = 0.0001;

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target, epsilon);

        assertTrue(result.isPresent());
        assertEquals(3, result.get());
    }

    @Test
    @DisplayName("Should handle floating point precision with epsilon")
    void testFindSquaredNumberIndex_DoubleArray_Epsilon() {
        double[] numbers = {1.0, 1.414, 2.0, 3.0};
        double target = 2.0; // 1.414^2 ≈ 1.999396 (close to 2.0)
        double epsilon = 0.001;

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target, epsilon);

        assertTrue(result.isPresent());
        assertEquals(1, result.get());
    }

    @Test
    @DisplayName("Should return empty when no match within epsilon in double array")
    void testFindSquaredNumberIndex_DoubleArray_NotWithinEpsilon() {
        double[] numbers = {1.0, 1.4, 2.0, 3.0};
        double target = 2.0;
        double epsilon = 0.0001; // Very small epsilon

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target, epsilon);

        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Should throw exception when double array is null")
    void testFindSquaredNumberIndex_DoubleArray_Null() {
        double[] numbers = null;
        double target = 16.0;
        double epsilon = 0.0001;

        assertThrows(IllegalArgumentException.class, () -> {
            ArrayUtils.findSquaredNumberIndex(numbers, target, epsilon);
        });
    }

    @Test
    @DisplayName("Should find first occurrence when multiple numbers square to target")
    void testFindSquaredNumberIndex_MultipleMatches() {
        int[] numbers = {-3, 1, 2, 3, 4};
        int target = 9; // Both -3 and 3 square to 9

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertTrue(result.isPresent());
        assertEquals(0, result.get()); // Should find first occurrence at index 0
    }

    @Test
    @DisplayName("Should handle large numbers")
    void testFindSquaredNumberIndex_LargeNumbers() {
        int[] numbers = {100, 200, 300, 1000};
        int target = 1000000; // 1000^2 = 1000000

        Optional<Integer> result = ArrayUtils.findSquaredNumberIndex(numbers, target);

        assertTrue(result.isPresent());
        assertEquals(3, result.get());
    }
}
