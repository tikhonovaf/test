package stream;

import java.util.List;

public class StreamSeq {

    public static void main(String[] args) {
        final List<String> list = List.of("dog", "cat", "hamster");
        list.stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.length() <= 3;
                })
                .sorted()
                .map(s1 -> {
                    System.out.println("map: " + s1);
                    return s1.toUpperCase();
                })
//                .skip(1)
                .forEach(x -> {
                    System.out.println("forEach: " + x);
                });
    }
}
