package com.talbn1.java_functional_programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author talbn on 10/6/2020
 **/

public class FP03BehaviorParameterization {
    
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        
        //we are passing the logic as parameter! we are passing algorithms
        
        Predicate<? super Integer> predicateEven = x -> x % 2 == 0;
        Predicate<? super Integer> predicateOdd = x -> x % 2 != 0;
        Predicate<? super Integer> predicateDivideBy3 = x -> x % 3 == 0;
        
        filterAndPrint(numbers, predicateEven);
        filterAndPrint(numbers, predicateOdd);
        filterAndPrint(numbers, predicateDivideBy3);
        
        
        //Passing Function to Function!
        Function<Integer, Integer> mappingFunction = x -> x * x;
        
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, mappingFunction);
        
        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);
        
        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);
        
        System.out.println(doubledNumbers);
        
    }
    
    private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
                                                     Function<Integer, Integer> mappingFunction) {
        return numbers.stream()
                .map(mappingFunction)
                .collect(Collectors.toList());
    }
    
    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}