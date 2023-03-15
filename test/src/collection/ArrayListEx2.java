package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListEx2 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("A");
        StringBuilder sb2 = new StringBuilder("B");
        StringBuilder sb3 = new StringBuilder("C");
        StringBuilder sb4 = new StringBuilder("D");
        StringBuilder [] la = {sb1, sb2, sb3, sb4};

        List<StringBuilder> l1 = Arrays.asList(la);

        System.out.println(l1);



    }

}
