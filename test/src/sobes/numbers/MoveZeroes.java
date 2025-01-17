package sobes.numbers;

import java.util.HashSet;
import java.util.Set;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;

// Перемещаем все ненулевые элементы в начало массива
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

// Заполняем оставшиеся элементы нулями
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = {0, 1, 0, 12, 3};
        solution.moveZeroes(nums);
        // Вывод: [1, 3, 12, 0, 0]
        for (int num : nums) {
            System.out.println(num + " ");
        }

        Set<Integer> hashSet = new HashSet<Integer>();
        //Populating the HashSet
        hashSet.add(1124);
        hashSet.add(3654);
        hashSet.add(7854);
        hashSet.add(9945);
        //Adding null elements
        hashSet.add(null);
        hashSet.add(null);
        System.out.println(hashSet);

    }

}
