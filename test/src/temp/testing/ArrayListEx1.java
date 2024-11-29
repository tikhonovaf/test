package temp.testing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListEx1 {
    public static void main(String[] args) {
        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> collect = Stream.of(array)     // Stream<String[]>
                .flatMap(Stream::of)                // Stream<String>
                .filter(x -> !"a".equals(x))        // filter out the a
                .collect(Collectors.toList());      // return a List

        collect.forEach(v ->System.out.println(v));

        String s1 = new String();
        String s2 = new String();
        s1.hashCode();


    }

}


