package com.learnjava.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//TODO: extract into a playground
public class WordSearchRepository {

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        ArrayList<List<String>> result = new ArrayList<>();

        if (customerQuery != null && customerQuery.length() > 1) {
            for (int i = 2; i < customerQuery.length() + 1; i++) {
                final int index = i;
                List<String> resultLine = repository
                        .parallelStream()
                        .filter(entry -> entry.length() >= index && entry.substring(0, index).equalsIgnoreCase(customerQuery.substring(0, index)))
                        .sorted(String::compareToIgnoreCase)
                        .collect(Collectors.toList());
                if (resultLine.size() > 3) {
                    resultLine = resultLine.subList(0, 3);
                }
                result.add(resultLine);
            }
        }
        return result;
    }
}
