package stream;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {
    public static void main(String[] args) {

//        System.out.println(e.getName())
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int result = numbers.stream()
                .reduce(4, Integer :: sum );
        System.out.println(result);
    }
}
