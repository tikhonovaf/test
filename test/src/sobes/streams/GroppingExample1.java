package sobes.streams;

import sobes.streams.stream.flatMap1.Product;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroppingExample1 {
    public static void main(String[] args) {

        var res =
                Arrays.asList(1, 1, 2, 2, 4, 1, 1, 7, 1, 8, 7, 2)
                        .stream()
//                        .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue()) // Optional<Map.Entry<Integer, Foo>>
                        .orElseThrow()
;
        System.out.println(res.getKey() + "  " + res.getValue());
    }
}
