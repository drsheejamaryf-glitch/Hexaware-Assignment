package service;

@FunctionalInterface
public interface StudentFilter {

    boolean filter(int marks);
}