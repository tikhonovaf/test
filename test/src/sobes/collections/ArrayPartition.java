package sobes.collections;
import java.util.Arrays;

/*
��� ������ ����� ����� nums �� 2n ���������.
��������� ��� ����� �� n ��� (a1, b1), (a2, b2), ..., (an, bn) ���, ����� ����� min(ai, bi) ��� ���� i ���� ������������.
������� ������������ �����.

��� ������� ���� ������ �� Java ����� ��������������� ������ ����������.
������� ����������� ������, � ����� ����� ����� ����������� �������� �� ������ ����. ��� ������ ����:
 */
public class ArrayPartition {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayPartition ap = new ArrayPartition();
        int[] nums = {1, 4, 3, 2};
        System.out.println(ap.arrayPairSum(nums)); // Output: 4
    }

}
