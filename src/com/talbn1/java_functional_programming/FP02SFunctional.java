package com.talbn1.java_functional_programming;

/**
 * @author talbn on 10/1/2020
 **/

public class FP02SFunctional {

    public static void main(String[] args) {
        java.util.List<Integer> numbers = java.util.List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        java.util.List<String> courses = java.util.List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        //int sum = addListFunctional(numbers);
        //int sum = squareEveryNumberAndFindTheSumOfSquares(numbers);\
        //int sum = findSumOfOddNumbersInList(numbers);
        //sortAListByComparatorNaturalOrder(courses);
        //sortAListByComparatorByStringLength(courses);
        //java.util.List<Integer> list = createDoubleList(numbers);
        //java.util.List<Integer> list = listWithEvenNumbersFiltered(numbers);
        java.util.List<Integer> list =lengthsOfAllCourseTitles(courses);
                System.out.println(list);
    }

    private static int addListFunctional(java.util.List<Integer> numbers) {
        //reduce (x,y) takes the value for x, add y into it and then return it back
        return numbers.
                stream().
                reduce(0, (x, y) -> x + y);
    }

    //Exercise 7 Square every number in a list and find the sum of squares
    private static int squareEveryNumberAndFindTheSumOfSquares(java.util.List<Integer> numbers) {
        return numbers.
                stream().
                map(x -> x * x). //every number replaced by its square
                reduce(0, Integer::sum); // all the squares add up
    }

    //Exercise 8 Cube every number in a list and find the sum of cubes
    private static int cubeEveryNumberInListAndFindTheSumOfCubes(java.util.List<Integer> numbers) {
        return numbers.
                stream().
                map(x -> x * x * x). //every number replaced by its square
                reduce(0, Integer::sum); // all the squares add up
    }

    //Exercise 9 Find Sum of Odd Numbers in a list
    private static int findSumOfOddNumbersInList(java.util.List<Integer> numbers) {
        return numbers.stream().
                filter(number -> number % 2 == 1).
                reduce(0, Integer::sum);
    }

    private static void sortAListByComparatorNaturalOrder(java.util.List<String> courses) {
        courses.
                stream().
                sorted(java.util.Comparator.naturalOrder()).
                forEach(System.out::println);
    }

    private static void sortAListByComparatorReverseOrder(java.util.List<String> courses) {
        courses.
                stream().
                sorted(java.util.Comparator.reverseOrder()).
                forEach(System.out::println);
    }

    private static void sortAListByComparatorByStringLength(java.util.List<String> courses) {
        courses.
                stream()
                .sorted(java.util.Comparator.comparing(str -> str.length())).
                forEach(System.out::println);
    }

    private static java.util.List<Integer> createDoubleList(java.util.List<Integer> numbers) {
        return numbers.
                stream().
                map(number -> number * number).
                collect(java.util.stream.Collectors.toList());
    }

   //Exercise 10 - Create a List with Even Numbers Filtered from the Numbers List
    private static java.util.List<Integer> listWithEvenNumbersFiltered (java.util.List<Integer> numbers){
        return numbers.
                stream().
                filter(number -> number % 2 == 1).collect(java.util.stream.Collectors.toList());
    }

    //Exercise 11 - Create a List with lengths of all course titles.
    private static java.util.List<Integer> lengthsOfAllCourseTitles (java.util.List<String> courses){
        return courses.stream().map(x -> x.length()).collect(java.util.stream.Collectors.toList());

    }
}
