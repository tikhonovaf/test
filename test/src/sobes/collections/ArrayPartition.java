package sobes.collections;
import java.util.Arrays;

/*
Дан массив целых чисел nums из 2n элементов.
Разделите эти числа на n пар (a1, b1), (a2, b2), ..., (an, bn) так, чтобы сумма min(ai, bi) для всех i была максимальной.
Верните максимальную сумму.

Для решения этой задачи на Java можно воспользоваться жадным алгоритмом.
Сначала отсортируем массив, а затем будем брать минимальные элементы из каждой пары. Вот пример кода:
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
