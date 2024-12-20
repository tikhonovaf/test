package temp.testing;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class SortIntArray {

    public static void main(String[] args) {
//        int[] first = new int[]{3, 44, 6, 14, 23, 23, 254, 29, 30, 33, 36, 40, 766};
        int[] first = {3, 44, 6, 14, 23, 23, 254, 29, 30, 33, 36, 40, 766};
        int[] second = {2, 36, 6, 766, 15, 21, 26, 33, 39};

        Set<Integer> l1 = Arrays.stream(first)
                .boxed()
                .collect(Collectors.toSet());
        OptionalInt maxValue =
                Arrays.stream(second)
                        .filter(v-> {System.out.println(v);
                            return l1.contains(v);
                            })
                        .max();

        System.out.println(maxValue);
    }
}
