package com.thoughtworks.collection;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        int start = Math.min(leftBorder, rightBorder);
        int end = Math.max(leftBorder, rightBorder);
        while (start < end + 1) {
            if (start % 2 == 0) {
                sum = sum + start;
            }
            start++;
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int sum = 0;
        int start = Math.min(leftBorder, rightBorder);
        int end = Math.max(leftBorder, rightBorder);
        while (start < end + 1) {
            if (start % 2 == 1) {
                sum = sum + start;
            }
            start++;
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(x -> x * 3 + 2).reduce(0, Integer::sum);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 1) {
                arrayList.set(i, arrayList.get(i) * 3 + 2);
            }
        }
        return arrayList;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 1).map(x -> x * 3 + 5).reduce(0, Integer::sum);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> newList = arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        double median;
        int size = newList.size();
        if (size % 2 == 0) {
            median = (newList.get(size / 2) + newList.get(size / 2 - 1)) / 2.0;
        } else {
            median = newList.get(size - 1);
        }
        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 0).mapToDouble(Integer::intValue).average().getAsDouble();
    }

    public boolean isIncludedInEven(List<Integer> arrayList, Integer specialElement) {
        List<Integer> newList = arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        return newList.contains(specialElement);
    }

    public List<Integer> getUnrepeatedFromEven(List<Integer> arrayList) {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {

        List<Integer> evenList = arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream().filter(x -> x % 2 == 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        evenList.addAll(oddList);
        return evenList;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {

        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int num = (arrayList.get(i) + arrayList.get(i + 1)) * 3;
            newList.add(num);
        }
        return newList;
    }
}
