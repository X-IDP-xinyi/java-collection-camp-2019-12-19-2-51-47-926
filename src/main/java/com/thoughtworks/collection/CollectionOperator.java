package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left < right) {
            IntStream newList = IntStream.rangeClosed(left, right);
            return newList.boxed().collect(Collectors.toList());
        } else {
            IntStream newList = IntStream.rangeClosed(right, left);
            List<Integer> intList = newList.boxed().collect(Collectors.toList());
            Collections.reverse(intList);
            return intList;
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left < right) {
            IntStream newList = IntStream.rangeClosed(left, right);
            List<Integer> intList = newList.boxed().collect(Collectors.toList());
            return intList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        } else {
            IntStream newList = IntStream.rangeClosed(right, left);
            List<Integer> intList = newList.boxed().collect(Collectors.toList());
            Collections.reverse(intList);
            return intList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElements(int[] array) {

        return Arrays.stream(array).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElement(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> newList = new ArrayList<>();
        for (int first : firstArray) {
            for (int second : secondArray) {
                if (first == second) {
                    newList.add(first);
                }
            }
        }
        return newList;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(Arrays.asList(firstArray));
        newList.addAll(Arrays.asList(secondArray));
        return newList.stream().distinct().collect(Collectors.toList());
    }
}
