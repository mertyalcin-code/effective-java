package com.mertyalcin.effectivejava.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreamService {

    public String runBadMethod() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(i);
        }

        long startTime = System.nanoTime();

        List<Integer> squaredNumbers = numbers.parallelStream()
                .map(number -> number * number)
                .collect(Collectors.toList());

        long endTime = System.nanoTime();

       return "Time taken with parallel stream: " + (endTime - startTime) + " ns";
    }
    public String runGoodMethod() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            numbers.add(i);
        }

        // Ardışık akış kullanımı
        long startTimeSequential = System.nanoTime();
        List<Integer> squaredNumbersSequential = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        long endTimeSequential = System.nanoTime();
        return "Time taken with sequential stream: " + (endTimeSequential - startTimeSequential) + " ns";
    }
}
