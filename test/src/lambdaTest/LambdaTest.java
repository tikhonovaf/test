package lambdaTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", 'm', 35, 3, 8.3));
        students.add(new Student("Nikolay", 'm', 25, 2, 6.4));
        students.add(new Student("Elena", 'f', 33, 4, 6.4));

        System.out.println("--------------------------------------------");
        System.out.println(students);

        StudentInfo studentInfo = new StudentInfo();
//        Collections.sort(students, new Comparator<Student>() {
//
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.course - s2.course;
//            }
//        });

        Collections.sort(students, (stud1, stud2) -> stud1.course - stud2.course);

        System.out.println("--------------------------------------------");
        System.out.println(students);

//        studentInfo.testStudents(students, new CheckOverGrade());
//        System.out.println("--------------------------------------------");
//        studentInfo.testStudents(students, (Student s) -> {
//            return s.age < 30;
//        });
//
//        System.out.println("--------------------------------------------");
//        studentInfo.testStudents(students, (Student s) -> {
//            return s.sex == 'f';
//        });

//        System.out.println("--------------------------------------------");
//        studentInfo.testStudents(students, s -> s.age < 35);
//        StudentsChecks sc = (Student s) -> {
//            return s.age < 35;
//        };
//
//        studentInfo.testStudents(students, sc);
//
//    }
    }
}
