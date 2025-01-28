package sobes.collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeAndSortLists {
    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();

        List<Integer> list1 = List.of(3,1,4);
        List<Integer> list2 = List.of(2,6,5);

//        List<Integer> list1 = Arrays.asList(3,1,4);
//        List<Integer> list2 = Arrays.asList(2,6,5);

// Пример данных
//        Collections.addAll(list1, 3, 1, 4);
//        Collections.addAll(list2, 2, 5, 6);

        List<Integer> mergedList = mergeAndSort(list1, list2);
        System.out.println(mergedList);
    }

    public static List<Integer> mergeAndSort(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList();
        mergedList.addAll(list1);
        mergedList.addAll(list2);
        Collections.sort(mergedList);
        return mergedList;
    }

}
