package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ArrayListEx2 {
    public static void main(String[] args) {
        String[] names = {"Java", "Kotlin", "Java"};
        String name = "Java";
        Predicate predicate = name::equals;
        Stream.of(names).filter(predicate).count(); name = "Kotlin";
        Stream.of(names).filter (predicate).count();    }
}

