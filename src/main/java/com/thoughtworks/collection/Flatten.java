package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flatten {

    Integer[][] array;
    public Flatten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimensional() {
        return Stream.of(array).flatMap(Stream::of).collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimensional() {
        List<Integer> result = Arrays.stream(array).flatMap(Stream::of).collect(Collectors.toList());
        return result.stream().distinct().collect(Collectors.toList());
    }
}
