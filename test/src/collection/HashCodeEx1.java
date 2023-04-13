package collection;

import java.util.*;

public class HashCodeEx1 {

    public static void main(String[] args) {
        Map<Student,Double>  map = new HashMap<>();
        Student st1 = new Student("Иван", "Иванов", 2);
        Student st2 = new Student("Петр", "Иванов", 3);
        Student st3 = new Student("Сергей", "Иванов", 4);
        map.put(st1, 1.4);
        map.put(st2, 2.4);
        map.put(st3, 3.4);
        System.out.println(map);

        Student st4 = new Student("Миша", "Иванов", 4);

        System.out.println("");



    }

}

class Student {
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, surname, course);
//    }
}

