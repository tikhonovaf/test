package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnmodifiableList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one", "two", "three");
        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println(unmodifiableList);

        unmodifiableList.add("four");

    }

}
