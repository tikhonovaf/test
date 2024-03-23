package lambdaTest;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest2 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", 'm', 35, 3, 8.3));
        students.add(new Student("Nikolay", 'm', 25, 2, 6.4));
        students.add(new Student("Elena", 'f', 33, 4, 6.4));

//        System.out.println("--------------------------------------------");
//        System.out.println(students);

        int w = (int)888.8;
        byte x = (byte)1000L;
        long y = (byte)1000000;
        byte z = (byte)10L;

        char c1 = 12;

        System.out.println(y);

        StudentInfo studentInfo = new StudentInfo();

//        System.out.println("--------------------------------------------");
//        studentInfo.testStudents(students, (Student s) -> {
//            return s.age < 35;
//        });

//        students.forEach(st -> {
//            System.out.println(st);
//            st.avgGrade *= 2;
//            System.out.println(st);
//        });

        double res = StudentInfo.avg(students, stud -> (double) stud.age);
//        System.out.println(res);

    }


}
