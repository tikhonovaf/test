package sobes.streams;

import sobes.streams.stream.flatMap1.Product;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroppingExample1 {
    public static void main(String[] args) throws Exception {

        final List<String> addresses = new ArrayList<>();
        addresses.add("add");
        final StringBuilder fsb = new StringBuilder("constant");
        fsb.append("add");

        var res =
                Arrays.asList(1, 1, 2, 2, 4, 2, 2,  7, 1, 8, 7, 2)
                        .stream()
//                        .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue()) // Optional<Map.Entry<Integer, Foo>>
                        .orElseThrow()
                        .getKey();
//        System.out.println(res.getKey() + "  " + res.getValue());
        System.out.println(res);
    }
}
