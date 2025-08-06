package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
Ссылки на методы и функциональные интерфейсы:
Познакомься с ссылками на методы — более чистым и умным способом передавать поведение в современной Java.
В связке с функциональными интерфейсами они позволяют писать лаконичный, читаемый и
элегантный код без потери типобезопасности и выразительности.
*/

public class MethodRefDemo {
    public static <T> List filter (List<T> items, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : items) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static boolean isEven (Integer x) {
        return x % 2 == 0;
    }
    public static boolean isNotEven (Integer x) {
        return x % 2 != 0;
    }

    public static Predicate<String > containsS (String strSearch) {
        return str ->  str.contains(strSearch);
    }

    public static void main(String[] args) {
        List<Integer> numbers    = Arrays.asList(10, 15,20, 25, 30);
        List<Integer> evensEven = filter(numbers, MethodRefDemo::isEven);
        List<Integer> evensNotEven = filter(numbers, MethodRefDemo::isNotEven);
        evensEven.forEach(System.out::println);
        evensNotEven.forEach(System.out::println);

        List<String> strings    = Arrays.asList("hgjhghj", "Alklkl", "ggggA");
        List<String> strWithA = filter(strings, MethodRefDemo.containsS("A"));

        strWithA.forEach(System.out::println);

    }
}
