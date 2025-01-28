package sobes.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnModifableList {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("one", "two", "three"));
        List<String> list2 = Arrays.asList("one", "two", "three");
        List<String> list = List.of("one", "two", "three");

        List<String> unmodifiableList = Collections.unmodifiableList(list);
//        list.set(0, "test1");
//        unmodifiableList.add("four");

//        UnmodifiableList uml = (UnmodifiableList) List.of("one", "two", "three");

    }

}
