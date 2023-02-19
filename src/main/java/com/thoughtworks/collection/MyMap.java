package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private final String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private final List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(value -> value * 3).collect(Collectors.toList());
    }

    public List<String> mapLetter() {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            newList.add(letterList.get(i));
        }
        return newList;
    }

    public List<String> mapLetters() {
        ArrayList<String> newList = new ArrayList<>();
        for (Integer n : array) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (n > 0) {
                if (n % 26 == 0) {
                    temp.add(26);
                    n = n / 26 - 1;
                    continue;
                }
                temp.add(n % 26);
                n = n / 26;
            }
            Collections.reverse(temp);
            newList.add(temp.stream().map(x -> letters[x - 1]).collect(Collectors.joining()));
        }
        return newList;
    }

    public List<Integer> sortFromBig() {
        array.sort(Comparator.reverseOrder());
        return array;
    }

    public List<Integer> sortFromSmall() {
        array.sort(Comparator.naturalOrder());
        return array;
    }
}
