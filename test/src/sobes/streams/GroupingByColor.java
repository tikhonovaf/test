package sobes.streams;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingByColor {

    public static void main(String[] args) {
        List<String> socks = List.of("red", "green", "red", "green", "black");
        List<String> socksWithourPair = socks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry-> entry.getValue()%2 == 1) // Optional<Map.Entry<Integer, Foo>>
//                .map(Map.Entry::getKey)
                .map((entry) -> entry.getKey())
                .toList();
        System.out.println(socksWithourPair);
    }

}
