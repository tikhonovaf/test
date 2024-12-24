package stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Map<Integer, String> mapOddNumbers = numbers.parallelStream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toMap(
                        Function.identity(),
                        String::valueOf,
                        (p1, p2 ) -> p1,
                        ConcurrentHashMap::new
                ));
        System.out.println(mapOddNumbers); // {1=1, 3=3, 5=5}
    }
}
