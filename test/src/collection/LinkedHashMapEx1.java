package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class LinkedHashMapEx1 {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("aa");
        al.add("bb");
        al.add("aa");
        System.out.println(al);
        while (al.remove("aa"));
        System.out.println(al);


//        LinkedHashMap<Double, Student> lhm = new LinkedHashMap<>(16,0.75f, true);
//        Student st1 = new Student("Иван", "Иванов", 2);
//        Student st2 = new Student("Петр", "Иванов", 3);
//        Student st3 = new Student("Сергей", "Иванов", 4);
//        lhm.put(1.4, st1);
//        lhm.put(2.5, st2);
//        lhm.put(3.4, st3 );
//        System.out.println(lhm);

    }

}



