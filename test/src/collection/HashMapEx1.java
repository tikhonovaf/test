package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapEx1 {
    public static void main(String[] args) {
        Map<Integer, String> map1 = new HashMap<>();
        Student st1 = new Student("Иван", "Иванов", 2);
        Student st2 = new Student("Петр", "Иванов", 3);
        Student st3 = new Student("Сергей", "Иванов", 4);
        map1.put(2, "Иван");
        map1.put(3, "Петр");
        System.out.println(map1);
        map1.put(2, "Сергей");
        System.out.println(map1);
        System.out.println(map1.containsValue("Сергей"));

        System.out.println(map1.keySet());
        System.out.println(map1.values());

    }
}
