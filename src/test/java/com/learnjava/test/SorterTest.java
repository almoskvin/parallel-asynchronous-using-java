package com.learnjava.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

//TODO: extract into a playground
class SorterTest {

    Sorter sorter = new Sorter();

    @ParameterizedTest
    @MethodSource("arraysArgumentSourceProvider")
    void sort(int[] testInput, int[] testSorted, Sorter.Algorithm algorithm) {
        int[] sorted = algorithm == Sorter.Algorithm.BUBBLE ? sorter.sort(testInput) : sorter.sort(testInput, algorithm);
        Assertions.assertArrayEquals(testSorted, sorted);
    }

    private static Stream<Arguments> arraysArgumentSourceProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 8, 4, 6, 2, 7, 10},
                        new int[]{1, 2, 4, 6, 7, 8, 10},
                        Sorter.Algorithm.BUBBLE),
                Arguments.of(new int[]{1, 8, 4, 6, 2, 7, 10},
                        new int[]{1, 2, 4, 6, 7, 8, 10},
                        Sorter.Algorithm.INSERTION),
                Arguments.of(new int[]{153, 84, 5, 26, 3, 78, 1, 89, 899, 15, 64, 2, 0, -115, 4},
                        new int[]{-115, 0, 1, 2, 3, 4, 5, 15, 26, 64, 78, 84, 89, 153, 899},
                        Sorter.Algorithm.BUBBLE),
                Arguments.of(new int[]{153, 84, 5, 26, 3, 78, 1, 89, 899, 15, 64, 2, 0, -115, 4},
                        new int[]{-115, 0, 1, 2, 3, 4, 5, 15, 26, 64, 78, 84, 89, 153, 899},
                        Sorter.Algorithm.INSERTION),
                Arguments.of(new int[]{1364, 9221, 6147, 9432, 3154, 4232, 8338, 8883, 2266, 5876, 8500, 1214, 8862, 1966, 8068, 9584, 8451, 3043, 9629, 5371, 6296, 9565, 8666, 2817, 6854, 7853, 9159, 6266, 3868, 4684, 2749, 1998, 2459, 1936, 2004, 5923, 8066, 2342, 2221, 4142, 5657, 4536, 2555, 4600, 45, 6017, 228, 9347, 9199, 6907, 3075, 1635, 3233, 7342, 9444, 9094, 9310, 2368, 7266, 4265, 4734, 1295, 8451, 5737, 8424, 2451, 709, 1227, 8749, 1903, 4903, 3153, 9538, 5767, 9043, 1739, 9810, 5776, 5142, 4734},
                        new int[]{45, 228, 709, 1214, 1227, 1295, 1364, 1635, 1739, 1903, 1936, 1966, 1998, 2004, 2221, 2266, 2342, 2368, 2451, 2459, 2555, 2749, 2817, 3043, 3075, 3153, 3154, 3233, 3868, 4142, 4232, 4265, 4536, 4600, 4684, 4734, 4734, 4903, 5142, 5371, 5657, 5737, 5767, 5776, 5876, 5923, 6017, 6147, 6266, 6296, 6854, 6907, 7266, 7342, 7853, 8066, 8068, 8338, 8424, 8451, 8451, 8500, 8666, 8749, 8862, 8883, 9043, 9094, 9159, 9199, 9221, 9310, 9347, 9432, 9444, 9538, 9565, 9584, 9629, 9810},
                        Sorter.Algorithm.BUBBLE),
                Arguments.of(new int[]{1364, 9221, 6147, 9432, 3154, 4232, 8338, 8883, 2266, 5876, 8500, 1214, 8862, 1966, 8068, 9584, 8451, 3043, 9629, 5371, 6296, 9565, 8666, 2817, 6854, 7853, 9159, 6266, 3868, 4684, 2749, 1998, 2459, 1936, 2004, 5923, 8066, 2342, 2221, 4142, 5657, 4536, 2555, 4600, 45, 6017, 228, 9347, 9199, 6907, 3075, 1635, 3233, 7342, 9444, 9094, 9310, 2368, 7266, 4265, 4734, 1295, 8451, 5737, 8424, 2451, 709, 1227, 8749, 1903, 4903, 3153, 9538, 5767, 9043, 1739, 9810, 5776, 5142, 4734},
                        new int[]{45, 228, 709, 1214, 1227, 1295, 1364, 1635, 1739, 1903, 1936, 1966, 1998, 2004, 2221, 2266, 2342, 2368, 2451, 2459, 2555, 2749, 2817, 3043, 3075, 3153, 3154, 3233, 3868, 4142, 4232, 4265, 4536, 4600, 4684, 4734, 4734, 4903, 5142, 5371, 5657, 5737, 5767, 5776, 5876, 5923, 6017, 6147, 6266, 6296, 6854, 6907, 7266, 7342, 7853, 8066, 8068, 8338, 8424, 8451, 8451, 8500, 8666, 8749, 8862, 8883, 9043, 9094, 9159, 9199, 9221, 9310, 9347, 9432, 9444, 9538, 9565, 9584, 9629, 9810},
                        Sorter.Algorithm.INSERTION)
        );
    }
}