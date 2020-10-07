package com.talbn1.java_functional_programming;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author talbn on 10/6/2020
 **/
public class FP03MethodReferences {
    
    private static void print(String str) {
        System.out.println(str);
    }
    
    public static void main(String[] args) {
    
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices",
                "AWS", "PCF", "Azure", "Docker",
                "Kubernetes");
    
        courses.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);
    
        Supplier<String> supplier = String::new;
    }
}
