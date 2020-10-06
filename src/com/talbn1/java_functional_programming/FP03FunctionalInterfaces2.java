package com.talbn1.java_functional_programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * @author talbn on 10/6/2020
 **/
public class FP03FunctionalInterfaces2 {
    
    //PREDICATE USE FOR BOOLEANS LOGIC
    //FUNCTIONS FOR other
    
    public static void main(String[] args) {
        
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        
        // Represents a predicate (boolean-valued function) of one argument
        Predicate<Integer> isEvenPredicate = (Integer x) -> x % 2 == 0;
        
        // Represents a function that accepts one argument and produces a result. <in> <result>
        Function<Integer, Integer> squareFunction = x -> x * x;
        
        // Can accept two different value types
        Function<Integer, String> stringOutputFunction = x -> x + " ";
        
        // Represents an operation that accepts a single input argument and returns no result.
        Consumer<Integer> sysoutConsumer = x -> System.out.println(x);
        
        // Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
        // This is a specialization of BiFunction for the case where the operands and the result are all of the same type.
        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;
        System.out.println(sumBinaryOperator.apply(10,50));
    
        // Represents an operation on a single operand that produces a result of the same type as its operand.
        UnaryOperator<Integer> unaryOperator = (x) -> x * 3;
        System.out.println(unaryOperator.apply(10));
        
        
        // No Input but returning something back
        // Represents a supplier of results.
        // /No input > Return Something
        Supplier<Integer> randomIntegerSupplier = () -> {
            Random random = new Random();
            return random.nextInt(1000);
        };
        for (int i = 0; i < 5; i++) { System.out.println(randomIntegerSupplier.get()); }

        
        // can take two arguments - but return boolean
        BiPredicate<Integer, String> biPredicate = (number, str) -> {
            return number<10 && str.length()>5;
        };
        System.out.println(biPredicate.test(5, "abcdef"));
    
        // can take two arguments - you decide the return type
        BiFunction<Integer, String, Boolean> biFunction = (number, str) -> {
            return number<10 && str.length()>5;
        };
        
        BiFunction<Integer, String, String> biFunction2 = (number, str) -> {
            return number + " " + str;
        };
        System.out.println(biFunction2.apply(15, "this is a test"));
    
    
        //
        BiConsumer<Integer, String> biConsumer = (x,y) -> {
            System.out.print(x);
            System.out.println(y);};
        
        biConsumer.accept(131,"testtest");
    }
    
    
    
}
