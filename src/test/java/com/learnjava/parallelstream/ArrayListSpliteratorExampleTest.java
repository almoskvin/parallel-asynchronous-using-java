package com.learnjava.parallelstream;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListSpliteratorExampleTest {

    ArrayListSpliteratorExample example = new ArrayListSpliteratorExample();

    @RepeatedTest(5)
    void multiplyEachValueArrayList() {
        int size = 1000000;
        ArrayList<Integer> testList = DataSet.generateArrayList(size);
        System.out.println("AL Sequential");
        List<Integer> resultList = example.multiplyEachValue(testList, 2, false);
        assertEquals(size, resultList.size());
    }

    @RepeatedTest(5)
    void multiplyEachValueArrayListInParallel() {
        int size = 1000000;
        ArrayList<Integer> testList = DataSet.generateArrayList(size);
        System.out.println("AL Parallel");
        List<Integer> resultList = example.multiplyEachValue(testList, 2, true);
        assertEquals(size, resultList.size());
    }

    @RepeatedTest(5)
    void multiplyEachValueLinkedList() {
        int size = 1000000;
        LinkedList<Integer> testList = DataSet.generateIntegerLinkedList(size);
        System.out.println("LL Sequential");
        List<Integer> resultList = example.multiplyEachValue(testList, 2, false);
        assertEquals(size, resultList.size());
    }

    @RepeatedTest(5)
    void multiplyEachValueLinkedListInParallel() {
        int size = 1000000;
        LinkedList<Integer> testList = DataSet.generateIntegerLinkedList(size);
        System.out.println("LL Parallel");
        List<Integer> resultList = example.multiplyEachValue(testList, 2, true);
        assertEquals(size, resultList.size());
    }
}