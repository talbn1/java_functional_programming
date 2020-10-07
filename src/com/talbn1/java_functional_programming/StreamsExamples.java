package com.talbn1.java_functional_programming;

import java.util.Comparator;
import java.util.stream.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * @author talbn on 10/7/2020
 **/
public class StreamsExamples {
    
    public static void main(String[] args) {
        
        IntStream.range(1, 10);
    
        System.out.println(
                IntStream.range(1, 10).sum()
        );
    
        System.out.println(
                IntStream.rangeClosed(1, 10).sum()
        );
    
        System.out.println(
                IntStream.
                        iterate(1, e -> e + 2).
                        limit(10).
                        peek(System.out::println).
                        sum()
        );
    }
}
