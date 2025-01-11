package sobes.numbers;

import java.util.Arrays;
import java.util.Comparator;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) {
                nums[i] = 0;
            }
        }

    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = {0, 1, 0, 12, 3};
        solution.moveZeroes(nums);
// Вывод: [1, 3, 12, 0, 0]
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
