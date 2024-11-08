package common;

// Java code to print the elements of Stream
// without using double colon operator

import java.util.stream.*;

class Test1 {
    public static void main(String[] args)
    {

        // Get the stream
        Stream<String> stream
                = Stream.of("Geeks", "For",
                "Geeks", "A",
                "Computer",
                "Portal");

        // Print the stream
//        stream.forEach(
//                s -> System.out.println(s)
//        );
        stream.forEach(System.out::println);



    }
}
