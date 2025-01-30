package sobes.numbers;

import java.util.ArrayList;
import java.util.List;

// ���� ��� ��������������� �������.
// ������� ��� �������� ������� �������,
// ������� �� ����������� �� ������.
// filter([1, 2, 3], [2, 3, 4]) => [1]

public class SortArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5};
        int[] arr2 = {2, 3, 4};
        List<Integer> result = filter(arr1, arr2);
        System.out.println(result); // [1]
    }

    public static List<Integer> filter(int[] arr1, int[] arr2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result.add(arr1[i]);
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        while (i < arr1.length) {
            result.add(arr1[i]);
            i++;
        }
        return result;
    }
}
