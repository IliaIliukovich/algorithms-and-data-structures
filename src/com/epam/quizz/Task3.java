package com.epam.quizz;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;

/* 3.	В компании epam проводятся N курсов. Каждый с датой начала и конца.
Вы решили пройти как можно больше из них, но не можете проходить одновременно 2 курса.
Напишите программу выбора максимального числа курсов, которые вы можете пройти. */
public class Task3 {

    public static void main(String[] args) {

        List<Course> courseList = new LinkedList<>();
        courseList.add(new Course("Math   ", LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 0),
                                                   LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 10)));
        courseList.add(new Course("C++    ", LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 20),
                                                   LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 30)));
        courseList.add(new Course("Java   ", LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 5),
                                                   LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 25)));
        courseList.add(new Course("Patterns", LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 29),
                                                    LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 35)));
        courseList.add(new Course("Spring  ", LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 45),
                                                    LocalDateTime.of(2017, Month.JANUARY, 17, 10, 0, 55)));
        System.out.println("All courses:");
        courseList.forEach(System.out::println);

        List<Course> maxList = getOptimalCoursesList(courseList);
        System.out.println("Result:");
        maxList.forEach(System.out::println);
    }

    // Algorithm efficiency ~ N!, where N - number of courses
    private static List<Course> getOptimalCoursesList(List<Course> courseList) {
        List<Course> maxList = getMaxList(courseList);
        maxList.sort(Comparator.comparing(o -> o.start));
        return maxList;
    }

    private static List<Course> getMaxList(List<Course> courseList) {
        List<Course> maxList = new LinkedList<>();
        for (Course course : courseList) {
            List<Course> sublist = courseList.stream().filter(e -> canBeTogether(course, e)).collect(Collectors.toList());
            List<Course> curMaxList = (sublist.size() <= 1) ? sublist : getMaxList(sublist);
            if (curMaxList.size() > maxList.size() - 1) {
                maxList = curMaxList;
                maxList.add(course);
            }
        }
        return maxList;
    }

    private static boolean canBeTogether(Course course1, Course course2) {
        return !course2.equals(course1) && (course2.start.isAfter(course1.end) || course2.end.isBefore(course1.start));
    }


    private static class Course {
        String name;
        LocalDateTime start;
        LocalDateTime end;

        public Course(String name, LocalDateTime start, LocalDateTime end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
