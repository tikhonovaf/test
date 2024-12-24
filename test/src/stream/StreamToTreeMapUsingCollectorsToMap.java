package stream;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToTreeMapUsingCollectorsToMap {

    public static void main(String[] args) {

        // 1. Stream of String tokens
        Stream<String> nameStream = Stream.of(
                "Rajiv",
                "Anbu",
                "Santosh",
                "Abdul",
                "Lingaraj"
        );


        // 2. convert Stream<String> to TreeMap<String, Integer>
        Map<String, Integer> tMap = nameStream
                .collect(Collectors.toMap(
                        Function.identity(), // 1. actual String as KEY
                        String::length  // 2. String length as their VALUE
//                        (key1, key2) -> key1, // 3. duplicate KEY resolver
//                        TreeMap::new // 4. implementation-class
                ));


        // 2.1 print to console
        System.out.println("Stream to TreeMap conversion : \n\n" + tMap);
    }
}