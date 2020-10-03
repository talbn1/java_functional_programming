package com.talbn1.java_functional_programming;

import java.util.List;

/**
 * @author talbn on 10/1/2020
 **/
public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        //printAllNumbersInListFunctional(numbers);
        //printEvenNumbersInListFunctional(numbers);
        //printOddNumbersInListFunctional(numbers);
        //printCourses(courses);
        //printOnlySpring(courses);
        //printAtleast4LettersList(courses);
        //printCubesOfOddNumbers(numbers);
        printNumberOfEachCourseName(courses);
    }

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().forEach(System.out::println);// Method Reference
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 == 0).forEach(System.out::println);
    }

    //Exercise 1
    private static void printOddNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 == 1).forEach(System.out::println);
    }

    //Exercise 2 Print All Courses individually
    private static void printCourses(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

    //Exercise 3 Print Courses Containing the word "Spring"
    private static void printOnlySpring(List<String> courses) {
        courses.stream().filter(course -> course.equals("Spring")).forEach(System.out::println);
    }

    //Exercise 4 Print Courses Whose Name has at least 4 letters
    private static void printAtleast4LettersList(List<String> courses) {
        courses.stream().filter(course -> course.length() > 3).forEach(System.out::println);
    }

    //Exercise 5 Print the cubes of odd numbers
    private static void printCubesOfOddNumbers(List<Integer> numbers) {
        numbers.stream().
                filter(number -> number % 2 == 1).
                map(number -> number * number * number).
                forEach(System.out::println);
    }

    //Exercise 6 Print the number of characters in each course name
    private static void printNumberOfEachCourseName(List<String> courses) {
        courses.stream().map(course -> course + " " + course.length())
                .forEach(System.out::println);
    }





}
