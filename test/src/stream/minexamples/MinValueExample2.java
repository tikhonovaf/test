package stream.minexamples;

import java.util.Arrays;
import java.util.Optional;

public class MinValueExample2 {


    public static void main(String[] args) {

        // Comparing strings based on last characters.
// creating an array of strings
        String[] array = {"Geeks", "for1", "GeeksforGeeks0",
                "GeeksQuiz"};

        // The Comparator compares the strings
        // based on their last characters and returns
        // the minimum value accordingly.
        Optional<String> minValue = Arrays.stream(array)
                .min((str1, str2) ->
                        Character.compare(str1.charAt(str1.length() - 1),
                                str2.charAt(str2.length() - 1)
                        ));
        ;
//     If a value is present,
//     isPresent() will return true

        if (minValue.isPresent())
            System.out.println(minValue.get());
        else
            System.out.println("-1");

    }
}


