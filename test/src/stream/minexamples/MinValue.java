package stream.minexamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinValue {
    public static void main(String[] args) {
        // Creating a list of integers
        List<Integer> list = Arrays.asList(-9, -18, 0, 25, 4);

        // Using stream.min() to get minimum
        // element according to provided Integer Comparator
        Integer var = list.stream().min(Integer::compare).get();
        System.out.println(var);

        Integer var1 = list.stream().min(Integer::compareTo).get();
        System.out.println(var1);

        Integer var2 = list.stream().min(Comparator.reverseOrder()).get();
        System.out.println(var2);

    }
}
