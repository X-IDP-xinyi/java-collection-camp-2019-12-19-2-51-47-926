package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;

public class InverseReduce {

    public List<Integer> divideToSmaller(int number) {
        List<Integer> newList = new ArrayList<>();
        while (number > 1) {
            number = number - 2;
            newList.add(number);
        }
        return newList;
    }
}
