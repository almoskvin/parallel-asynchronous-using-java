package com.learnjava.forkjoin;

import com.learnjava.util.DataSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static com.learnjava.util.CommonUtil.delay;
import static com.learnjava.util.CommonUtil.stopWatch;
import static com.learnjava.util.LoggerUtil.log;

public class StringTransformUsingRecursion extends RecursiveTask<List<String>> {

    private List<String> inputList;

    public StringTransformUsingRecursion(List<String> names) {
        this.inputList = names;
    }

    public static void main(String[] args) {

        stopWatch.start();
        List<String> names = DataSet.namesList();
        log("names : " + names);

        StringTransformUsingRecursion stringTransformUsingRecursion = new StringTransformUsingRecursion(names);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<String> resultList = forkJoinPool.invoke(stringTransformUsingRecursion);

        stopWatch.stop();
        log("Final Result : " + resultList);
        log("Total Time Taken : " + stopWatch.getTime());
    }


    private static String addNameLengthTransform(String name) {
        delay(500);
        return name.length() + " - " + name;
    }

    @Override
    protected List<String> compute() {
        if (inputList.size() == 1) {
            return Collections.singletonList(addNameLengthTransform(inputList.get(0)));
        }
        int midpoint = inputList.size() / 2;
        StringTransformUsingRecursion leftListTask = new StringTransformUsingRecursion(inputList.subList(0, midpoint)); //instance of ForkJoinTask
        StringTransformUsingRecursion rightListTask = new StringTransformUsingRecursion(inputList.subList(midpoint, inputList.size())); //instance of ForkJoinTask
        invokeAll(leftListTask, rightListTask);

        List<String> resultList = new ArrayList<>(leftListTask.join());
        resultList.addAll(rightListTask.join());
        return resultList;
    }
}
