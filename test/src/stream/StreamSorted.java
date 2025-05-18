package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamSorted {

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
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toList());
//        System.out.println(res.getKey() + "  " + res.getValue());
        System.out.println(res);
    }

//
//    var sortedBps = taskList.keySet().stream()
//            .sorted(Comparator.comparing({ y -> y.getY() })
//                    .thenComparing(Comparator.comparing({ x -> x.getX() })))
//            .collect(Collectors.toList())


}
