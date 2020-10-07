package com.talbn1.java_functional_programming;

/**
 * @author talbn on 10/6/2020
 **/

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;
    
    public Course(String name, String category, int reviewScore, int noOfStudents) {
        super();
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getReviewScore() {
        return reviewScore;
    }
    
    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }
    
    public int getNoOfStudents() {
        return noOfStudents;
    }
    
    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }
    
    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
    
}

public class FP04CustomClass {
    
    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));
        
        // allMatch, noneMatch, anyMatch
        
        //allMatch is all curses above 95?
        Predicate<Course> reviewScoreGreaterThan95Predicate =
                course -> course.getReviewScore() > 95;
        
        //allMatch  is all curses above 85?
        Predicate<Course> reviewScoreGreaterThan85Predicate = course -> course.getReviewScore() > 85;
    
        Predicate<Course> reviewScoreLessThan90Predicate
                = course -> course.getReviewScore() < 90;
        
        //--ALL MATCH--
        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        
        //--NON MATCH-- - non of the courses match this condition
        System.out.println(courses.stream().noneMatch(reviewScoreGreaterThan95Predicate));
        
        //--ANY MATCH--
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));
        
        //compare by class by one field
        Comparator<Course> comparingByNoOfStudentsInc =
                Comparator.comparingInt(Course::getNoOfStudents);
        
        //compare by class field reversed
        Comparator<Course> comparingByNoOfStudentsDec =
                Comparator.comparingInt(Course::getNoOfStudents).reversed();
        
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDec).collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
        
        //compare by class TWO fields
        Comparator<Course> comparingByTwoFieldsInc =
                Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Course::getReviewScore).reversed();
        
        System.out.println(courses.stream().sorted(comparingByTwoFieldsInc).collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
        
        //LIMIT
        System.out.println(courses.
                stream().
                sorted(comparingByTwoFieldsInc).
                limit(3).
                collect(Collectors.toList()));
        //[Microservices:25000:96, API:22000:97, Azure:21000:99]
        
        //SKIP - to skip the first # result.
        System.out.println(courses.
                stream().
                sorted(comparingByTwoFieldsInc).
                skip(3).
                collect(Collectors.toList()));
        //[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
        
        // SKIP + LIMIT
        System.out.println(courses.
                stream().
                sorted(comparingByTwoFieldsInc).
                skip(3).
                limit(2).
                collect(Collectors.toList()));
        //[AWS:21000:92, Spring:20000:98]
        
        //TAKE WHILE
        // picks all the values that 95+ and print them.
        System.out.println(courses.
                stream().
                takeWhile(course -> course.getReviewScore() >= 95).
                collect(Collectors.toList()));
        //[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]
        
        //DROP WHILE
        // drops all lines before find the first one that does not meat the critiria
        System.out.println(courses.
                stream().
                dropWhile(course -> course.getReviewScore() >= 95).
                collect(Collectors.toList()));
        
        //[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
        
        // MAX
        System.out.println(
                courses.
                        stream().
                        max(comparingByTwoFieldsInc)
        );
        //Optional[FullStack:14000:91]
        
        // min
        System.out.println(
                courses.
                        stream().
                        min(comparingByTwoFieldsInc)
        );
        //Optional[Microservices:25000:96]
    
        // or else, if condition return nothing, you can chose default item to return
        System.out.println(
                courses.
                        stream().
                        filter(reviewScoreGreaterThan85Predicate).
                        min(comparingByTwoFieldsInc).
                        orElse(   new Course("Spring Boot", "Framework", 95, 18000) ));
    
    
        System.out.println(
                courses.stream()
                        .filter(reviewScoreLessThan90Predicate)
                        .findFirst()
        );//Optional.empty
    
    
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findFirst()
        );//Optional[Spring:20000:98]
    
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .findAny()
        );//Optional[Spring:20000:98]
    
    
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .sum());
        //88000
    
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .average());
        //OptionalDouble[22000.0]
    
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .count());
        //4
    
        System.out.println(
                courses.stream()
                        .filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course::getNoOfStudents)
                        .max());
        //OptionalInt[25000]
    
        // groupingBy
        // group list by category
        System.out.println(courses.
                stream().
                collect(Collectors.
                        groupingBy(Course::getCategory))
        );
        //{Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
        // FullStack=[FullStack:14000:91], Microservices=[API:22000:97, Microservices:25000:96],
        // Framework=[Spring:20000:98, Spring Boot:18000:95]}
    
    
        // groupingBy
        // print the number of each category
        System.out.println(courses.
                stream().
                collect(Collectors.
                        groupingBy(Course::getCategory, Collectors.counting()))
        );
        //{Cloud=4, FullStack=1, Microservices=2, Framework=2}
    
    
        // groupingBy
        // get max value of specific category
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        //{Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}
    
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName, Collectors.toList()))));
        //{Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}
    
        
    
    
    
    
    
    
    }
    
    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> course.getReviewScore() > cutoffReviewScore;
    }
    
}