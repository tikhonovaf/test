package lambdaTest;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    String name;
    List<Student> studentList;

    public Faculty(String name) {
        this.name = name;
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudentToFaculty(Student st) {
        studentList.add(st);
    }


}
