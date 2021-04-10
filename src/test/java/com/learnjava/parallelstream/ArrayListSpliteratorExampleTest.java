package com.learnjava.parallelstream;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayListSpliteratorExampleTest {

    ArrayListSpliteratorExample example = new ArrayListSpliteratorExample();

    @RepeatedTest(5)
    void multiplyEachValue() {
        int size = 1000000;
        ArrayList<Integer> testList = DataSet.generateArrayList(size);
        System.out.println("Sequential");
        List<Integer> resultList = example.multiplyEachValue(testList, 2, false);
        assertEquals(size, resultList.size());
    }

    @RepeatedTest(5)
    void multiplyEachValueInParallel() {
        int size = 1000000;
        ArrayList<Integer> testList = DataSet.generateArrayList(size);
        System.out.println("Parallel");
        List<Integer> resultList = example.multiplyEachValue(testList, 2, true);
        assertEquals(size, resultList.size());
    }
}