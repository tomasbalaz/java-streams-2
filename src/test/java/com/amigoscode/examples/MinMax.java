package com.amigoscode.examples;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class MinMax {

    @Test
    public void min() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer min = numbers.stream()
                //.min((o1, o2) -> o1.compareTo(o2))
                //.min(Integer::compareTo)
                .min(Comparator.naturalOrder())
                .get();
        System.out.println(min);
    }

    @Test
    public void max() {
        List<Integer> numbers = List.of(1, 2, 3, 100, 23, 93, 99);

        Integer max = numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
        System.out.println(max);
    }
}
