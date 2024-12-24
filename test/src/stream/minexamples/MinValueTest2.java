package stream.minexamples;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MinValueTest2 {
    public static void main(String[] args) {

        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
        Integer expectedResult = 89;

        // then
        Integer max = listOfIntegers
                .stream()
//                .mapToInt(v -> v)
                .max(Integer::compareTo).orElseThrow(NoSuchElementException::new);

        System.out.println(max);
    }
}
