package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamArray {
    public static void main(String[] args) {
//        IntStream intStream = IntStream.range(1, 3);
//        LongStream longStream = LongStream.rangeClosed(1, 3);
//
//        int reducedParams = Stream.of(1, 2, 3)
//                .reduce(10, (a, b) -> a + b, (a, b) -> {
//                    System.out.println("combiner was called");
//                    return a + b;
//                });
        int [] ia = new int [] {1,2,2,4,5};
////        Arrays.stream(new int[]{1,2,2,4,5})
//        Arrays.stream(ia)
//                .forEach(x -> {
//                    System.out.println("forEach: " + x);
//                })
//        ;
//
//        var res = Arrays.stream(ia)
//                .toArray();
//        System.out.println("toArray: " + ia);

        var average = Arrays.stream(ia)
                .average();
        System.out.println("average: " + average);



    }
}
