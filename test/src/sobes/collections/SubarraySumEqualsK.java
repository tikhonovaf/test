package sobes.collections;

/*
��� ������ ����� ����� nums � ����� ����� k, ������� ����� ���������� �����������, ����� ������� ����� k.

��� ������� ���� ������ �� Java ����� ������������ ����� � �������������� ���-����� (HashMap) ��� ������������ ���������� ����

 */

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num;
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(solution.subarraySum(nums, k)); // Output: 2
    }

}
