package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FlatMapTest {

    public static void main(String[] args) {

        Map<Integer, List<Long>> inputMap = new HashMap<>();
        inputMap.put(1, Arrays.asList(0L, 1L, 2L));
        inputMap.put(2,Arrays.asList(3L,4L));

        Map<Long, Integer> outputMap = inputMap.entrySet().stream()
                .flatMap(entry -> {
                    System.out.println("entry  key " + entry.getKey());
                    var key = entry.getKey();
                    var value = entry.getValue();
                    return value.stream().map(num -> Map.entry(num,key));
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(outputMap);
    }

}
