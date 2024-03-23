package streamTest;

import lambdaTest.Student;
import lambdaTest.StudentInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", 'm', 35, 3, 8.3));
        students.add(new Student("Nikolay", 'm', 25, 2, 6.4));
        students.add(new Student("Elena", 'f', 33, 4, 6.4));

        System.out.println("--------------------------------------------");
        System.out.println(students);

//        List<Integer> courses = students
//                .stream()
//                .mapToInt(el -> el.getCourse())
//                .boxed()
//                .collect(Collectors.toList());
//
//        System.out.println(courses);

        int sum = students
                .stream()
                .mapToInt(el -> el.getCourse())
                .sum();
        System.out.println(sum);


        Double avg = students
                .stream()
                .mapToInt(el -> el.getCourse())
                .average().getAsDouble();
        System.out.println(avg);

        int min = students
                .stream()
                .mapToInt(el -> el.getCourse())
                .min().getAsInt();
        System.out.println(sum);


//        List<String> names = new ArrayList<>();
//        names.add("Ivan");
//        names.add("Nikolay");
//        names.add("Elena");
//
//        System.out.println("--------------------------------------------");
//        System.out.println(names);
//
//        String stNames1 = names
//                .stream()
//                .reduce( (a, e) -> a + " " + e ).get();
//
//        System.out.println(stNames1);

    }
}
