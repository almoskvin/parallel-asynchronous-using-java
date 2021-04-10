package com.learnjava.parallelstream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class ParallelStreamResultOrderTest {

    ParallelStreamResultOrder resultOrder = new ParallelStreamResultOrder();

    @Test
    void listOrder() {
        List<Integer> inputList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("List:");
        System.out.println("Input " + inputList);
        List<Integer> resultList = resultOrder.listOrder(inputList);
        System.out.println("Result " + resultList);
        // no specific tests here, just terminal output
    }

    @Test
    void setOrder() {
        Set<Integer> inputSet = Set.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println("Set:");
        System.out.println("Input " + inputSet);
        Set<Integer> resultList = resultOrder.setOrder(inputSet);
        System.out.println("Result " + resultList);
        // no specific tests here, just terminal output
    }
}