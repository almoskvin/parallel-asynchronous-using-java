package com.learnjava.parallelstream;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;


public class StringTransformationUsingStreams {

    public static void main(String[] args) {
        List<String> names = DataSet.namesList(); // List.of("Bob", "Jamie", "Jill", "Rick")
        startTimer();

        StringTransformationUsingStreams stringTransformationUsingStreams = new StringTransformationUsingStreams();
        List<String> resultList = stringTransformationUsingStreams.transFormStrings(names);

        timeTaken();
        log("Final result : " + resultList);
    }

    private List<String> transFormStrings(List<String> names) {
        return names
//                .stream() // Total Time Taken : 2083 (4 threads)
                .parallelStream() // Total Time Taken : 594 (4 threads)
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    private String addNameLengthTransform(String name) {
        delay(500);
        return name.length() + " - " + name;
    }
}
