package com.learnjava.parallelstream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ParallelStreamResultOrder {

    // ordered
    public List<Integer> listOrder(List<Integer> inputList) {
        return inputList
                .parallelStream()
                .map(v -> v * 2)
                .collect(Collectors.toList());
    }

    // unordered
    public Set<Integer> setOrder(Set<Integer> inputList) {
        return inputList
                .parallelStream()
                .map(v -> v * 2)
                .collect(Collectors.toSet());
    }
}
