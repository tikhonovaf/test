package collection;

import java.util.ArrayList;
import java.util.List;

public class Test123 {
    public static void main() {

        List list = new ArrayList();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.stream().forEach(s -> {
            System.out.println(s);
            list.add(s + "New");
        });

        int [] a =new int []  {1,2,3,3,4};



        System.out.println(a);
        int[] b =   {1,2,3,3,4};
        System.out.println(b);
        System.out.println(b);

    }
}