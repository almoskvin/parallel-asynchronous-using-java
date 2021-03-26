package com.learnjava.test;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

//TODO: extract into a playground
public class Sorter {

    public enum Algorithm {
        BUBBLE, INSERTION, QUICK, MERGE
    }

    StopWatch timer = new StopWatch();

    public int[] sort(int[] input) {
        return sort(input, Algorithm.BUBBLE);
    }

    public int[] sort(int[] input, Algorithm algorithm) {
        if (algorithm == null || input == null || input.length == 0) {
            System.out.println("Can't sort with provided arguments: algorithm: " + algorithm + "; input: " + Arrays.toString(input));
            return new int[0];
        }

        int[] result = new int[input.length];
        System.out.println("Input: {}" + Arrays.toString(input));
        timer.reset();
        timer.start();
        try {
            switch (algorithm) {
                case BUBBLE:
                    result = sortBubble(input);
                    break;
                case INSERTION:
                    result = sortInsertion(input);
                    break;
                case QUICK:
                    result = sortQuick(input);
                    break;
                case MERGE:
                    result = sortMerge(input);
                    break;
                default:
                    System.out.println("Can't use the sorting algorithm " + algorithm + ". Implementation isn't found");
            }
        } catch (Exception e) {
            System.out.println("Sorting interrupted with error");
            e.printStackTrace();
        }
        timer.stop();
        System.out.println("Test duration: " + timer.getNanoTime());
        System.out.println("Result: " + Arrays.toString(result));
        return result;
    }

    private int[] sortMerge(int[] input) {
        return input;
    }

    private int[] sortQuick(int[] input) {
        return input;
    }

    private int[] sortInsertion(int[] input) {
        System.out.println("Insertion sort algorithm. Complexity: O(n^2)");
        int temp;
        for (int i = 0; i < input.length; i++) {
            temp = input[i];
            for (int j = i - 1; j >= 0; j--) {
                if (temp < input[j]) {
                    input[j + 1] = input[j];
                    if (j == 0) {
                        input[j] = temp;
                        break;
                    }
                } else {
                    input[j + 1] = temp;
                    break;
                }
            }
        }
        return input;
    }

    private int[] sortBubble(int[] input) {
        System.out.println("Bubble sort algorithm. Complexity: O(n^2)");
        int temp;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }
}
