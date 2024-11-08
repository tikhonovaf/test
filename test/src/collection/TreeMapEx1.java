package collection;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TreeMapEx1 {

    public static void main(String[] args) {
        int[] a = new int[]  {1,2,3,3,4};
        System.out.println(a);
        int[] b =   {1,2,3,3,4};
        System.out.println(b);
        System.out.println(b);


        String[] names = {"Java", "Kotlin", "Java"}; String name = "Java";
        Predicate predicate = name::equals;
        Stream.of(names).filter(predicate).count();
        name = "Kotlin";
        Stream.of(names) .filter (predicate) .count();
        }
    }




