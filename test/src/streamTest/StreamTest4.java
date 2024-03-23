package streamTest;

import lambdaTest.Faculty;
import lambdaTest.Student;

import java.util.ArrayList;
import java.util.List;

public class StreamTest4 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", 'm', 35, 3, 8.3));
        students.add(new Student("Nikolay", 'm', 25, 2, 6.4));
        students.add(new Student("Elena", 'f', 33, 4, 6.4));

        Faculty f1 = new Faculty("Economics");
        f1.addStudentToFaculty(students.get(0));
//        f1.addStudentToFaculty(students.get(1));

        Faculty f2 = new Faculty("Math");
        f2.addStudentToFaculty(students.get(2));

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        facultyList
                .stream()
                .flatMap(f -> f.getStudentList()
                        .stream())
                .forEach(e -> System.out.println(e.getName()));

    }
}
