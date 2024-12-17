package common;

import java.util.*;

public class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o1; // ���������� � �������� �������
    }

    public static void main(String[] args) {

        // ���������� ������
        List<Integer> list = Arrays.asList(5, 1, 3, 4, 2);
        Collections.sort(list, new CustomComparator());
        System.out.println("C�uco�: " + list); // Cn��ok: [5, 4, 3, 2, 1
        // ���������� � Treeset
        TreeSet<Integer> treeSet = new TreeSet<>(new CustomComparator());
        treeSet.addAll(list);
        System.out.println("TreeSet: " + treeSet); // TreeSet: [5, 4, 3, 2, 1
        // ���������� � TreeNap
        TreeMap<Integer, String> treeMap = new TreeMap(new CustomComparator());
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        System.out.println("TreeMap: " + treeMap); // TreeMap: (3-Three, 2-Two, 1-One)
    }

}
