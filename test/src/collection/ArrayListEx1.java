package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
        System.out.println(arrayList1);
        String[] a2 = arrayList1.toArray(new String[0]);
        for (String a : a2) {
            System.out.println(a);
        }


//        List<String> arrayList2 = new ArrayList<>();
////        arrayList2.add("Zaur");
////        arrayList2.add("Ivan1");
////        arrayList2.add("Maria1");
//////        arrayList2.addAll(1, arrayList1);
//         arrayList2 = arrayList1.subList(1,3);
//
//        System.out.println(arrayList2);
//
//        arrayList2.containsAll(arrayList1);
//        System.out.println(arrayList2.containsAll(arrayList1));

    }

}
