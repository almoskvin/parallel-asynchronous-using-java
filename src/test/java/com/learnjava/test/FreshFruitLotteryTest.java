package com.learnjava.test;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FreshFruitLotteryTest {

    FreshFruitLottery lottery = new FreshFruitLottery();

    @Test
    void foo() {
        List<String> codeList = List.of("apple", "apple", "banana", "anything", "banana");
        List<String> shoppingCart = List.of("orange", "apple", "apple", "banana", "anything", "banana");
        int actual = lottery.foo(codeList, shoppingCart);
        System.out.println("Actual: " + actual);
        assertEquals(1, actual);

        codeList = List.of("apple", "apple", "banana", "anything", "banana");
        shoppingCart = List.of("banana", "orange", "banana", "apple", "apple");
        actual = lottery.foo(codeList, shoppingCart);
        System.out.println("Actual: " + actual);
        assertEquals(0, actual);

        codeList = List.of("apple", "apple", "banana", "anything", "banana");
        shoppingCart = List.of("apple", "banana", "apple", "banana", "orange", "banana");
        actual = lottery.foo(codeList, shoppingCart);
        System.out.println("Actual: " + actual);
        assertEquals(0, actual);
    }
}