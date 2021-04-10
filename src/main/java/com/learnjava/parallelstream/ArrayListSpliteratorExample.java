package com.learnjava.parallelstream;

import com.learnjava.util.CommonUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListSpliteratorExample {
    public List<Integer> multiplyEachValue(List<Integer> inputList, int multiplyValue, boolean runParallel) {
        CommonUtil.stopWatchReset();
        CommonUtil.startTimer();
        Stream<Integer> inputStream = runParallel ? inputList.parallelStream() : inputList.stream();
        List<Integer> resultList = inputStream
                .map(v -> v * multiplyValue)
                .collect(Collectors.toList());
        CommonUtil.timeTaken();
        return resultList;
    }
}
