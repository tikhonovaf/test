package sobes.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxValue {

    public static void main(String[] args) {
        List <Integer> ar = Arrays.asList(1, 4,4,6,7,8, 0);
        ar.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(System.out::println);
    }

}
