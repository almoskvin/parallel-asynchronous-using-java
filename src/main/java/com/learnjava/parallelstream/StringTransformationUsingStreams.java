package com.learnjava.parallelstream;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;


public class StringTransformationUsingStreams {
    public static int delayMilliSeconds = 500;

    public static void main(String[] args) {
        List<String> names = DataSet.namesList(); // List.of("Bob", "Jamie", "Jill", "Rick")
        startTimer();

        StringTransformationUsingStreams stringTransformationUsingStreams = new StringTransformationUsingStreams();
        List<String> resultList = stringTransformationUsingStreams.transformStrings(names, true);

        timeTaken();
        log("Final result : " + resultList);
    }

    public List<String> transformStrings(List<String> names, boolean isParallel) {
        Stream<String> namesStream = names.stream(); // Total Time Taken : 2083 (4 threads)
        if (isParallel) {
            namesStream.parallel(); // Total Time Taken : 594 (4 threads)
        }

        return namesStream
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    public String addNameLengthTransform(String name) {
        delay(delayMilliSeconds);
        return name.length() + " - " + name;
    }
}
