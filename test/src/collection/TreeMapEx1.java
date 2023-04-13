package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapEx1 {

    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();
        Student st1 = new Student("Иван", "Иванов", 2);
        Student st2 = new Student("Петр", "Иванов", 3);
        Student st3 = new Student("Сергей", "Иванов", 4);
        treeMap.put(1.4, st1);
        treeMap.put(2.5, st2);
        treeMap.put(3.4, st3 );
        System.out.println(treeMap);

    }

}



