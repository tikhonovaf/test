package sobes.common;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class DeletedNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(filter(new int[]{1, 2, 3}, new int[]{2, 3, 4}))); // [1]
    }

    // ���� ��� ��������������� �������.
    // ������� ��� �������� ������� �������,
    // ������� �� ����������� �� ������.
    // filter([1, 2, 3], [2, 3, 4]) => [1]
    private static int[] filter(int[] list1, int[] list2) {

        return null;
    }
}
