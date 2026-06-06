package main;

import model.Student;
import service.StudentFilter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(101,
                "Anu", "Java", 82, true));

        students.add(new Student(102,
                "Bala", "Java", 45, false));

        students.add(new Student(103,
                "Charan", "Python", 91, true));

        students.add(new Student(104,
                "Divya", "Java", 67, true));

        students.add(new Student(105,
                "Esha", "Python", 38, false));

        students.add(new Student(106,
                "Farhan", "DevOps", 74, true));

        students.add(new Student(107,
                "Gokul", "DevOps", 88, true));

        students.add(new Student(108,
                "Hari", "Java", 53, true));

        students.add(new Student(109,
                "Isha", "Python", 79, true));

        students.add(new Student(110,
                "John", "DevOps", 62, true));

        students.add(new Student(111,
                "Kavya", "Java", 95, true));

        students.add(new Student(112,
                "Lokesh", "Python", 49, false));

        // Unique Courses

        Set<String> courses =
                students.stream()
                        .map(Student::getCourse)
                        .collect(Collectors.toSet());

        System.out.println("Unique Courses");
        System.out.println(courses);

        // Group by Course

        Map<String, List<Student>> grouped =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getCourse));

        System.out.println(
                "\nStudents Grouped by Course");

        grouped.forEach((course, list) -> {

            System.out.print(course + " -> ");

            List<String> names =
                    list.stream()
                            .map(Student::getStudentName)
                            .collect(Collectors.toList());

            System.out.println(names);
        });

        // Passed Students

        List<Student> passedStudents =
                students.stream()
                        .filter(Student::isPassed)
                        .collect(Collectors.toList());

        System.out.println(
                "\nPassed Students");

        passedStudents.forEach(student ->
                System.out.println(
                        student.getStudentName()));

        // Total Marks

        int totalMarks =
                passedStudents.stream()
                        .mapToInt(Student::getMarks)
                        .sum();

        System.out.println(
                "\nTotal Marks");
        System.out.println(totalMarks);

        // Average Marks

        double average =
                passedStudents.stream()
                        .mapToInt(Student::getMarks)
                        .average()
                        .orElse(0);

        System.out.println(
                "\nAverage Marks");
        System.out.println(average);

        // Highest Marks

        Optional<Student> topper =
                passedStudents.stream()
                        .max(Comparator.comparing(
                                Student::getMarks));

        System.out.println(
                "\nHighest Marks Scorer");

        topper.ifPresent(student ->
                System.out.println(
                        student.getStudentName()
                                + " - "
                                + student.getMarks()));

        // Sorting

        List<Student> sorted =
                passedStudents.stream()
                        .sorted(
                                Comparator.comparing(
                                                Student::getMarks)
                                        .reversed()
                                        .thenComparing(
                                                Student::getStudentName))
                        .collect(Collectors.toList());

        System.out.println(
                "\nSorted Passed Students");

        sorted.forEach(System.out::println);

        // Course-wise Total Marks

        Map<String, Integer> courseWiseMarks =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getCourse,
                                Collectors.summingInt(
                                        Student::getMarks)));

        System.out.println(
                "\nCourse-wise Total Marks");

        courseWiseMarks.forEach(
                (course, marks) ->
                        System.out.println(
                                course + " -> " + marks));

        // Optional Search

        Optional<Student> searchStudent =
                students.stream()
                        .filter(student ->
                                student.getStudentId() == 110)
                        .findFirst();

        System.out.println(
                "\nOptional Search Result");

        if (searchStudent.isPresent()) {

            Student s = searchStudent.get();

            System.out.println(
                    "Student found: "
                            + s.getStudentName()
                            + " - "
                            + s.getCourse()
                            + " - "
                            + s.getMarks());
        }

        // Functional Interface Filter

        StudentFilter filter =
                marks -> marks >= 75;

        System.out.println(
                "\nStudents with Marks >= 75");

        students.stream()
                .filter(student ->
                        filter.filter(
                                student.getMarks()))
                .forEach(System.out::println);

        // Method Reference

        System.out.println(
                "\nFinal Report");

        sorted.forEach(System.out::println);
    }
}