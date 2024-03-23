package lambdaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentInfo {

    void testStudents(List<Student> sl, Predicate<Student> pr) {
        for (Student s : sl) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }

//        Function<Student, Double> f = student -> student.avgGrade;
    }


    public static double avg(List<Student> stList, Function<Student, Double> f) {
        double result = 0.0;
        for (Student st: stList) {
            result += f.apply(st);
        }
        result = result/stList.size();
        return result;
    }
}

//interface StudentsChecks {
//    boolean check(Student s);
//}

//class CheckOverGrade implements StudentsChecks {
//    @Override
//    public boolean check(Student s) {
//        return s.avgGrade > 8;
//    }

//}