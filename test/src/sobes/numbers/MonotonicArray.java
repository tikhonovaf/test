package sobes.numbers;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3}; // Пример массива
        System.out.println(isMonotonic(array));
    }

    public static boolean isMonotonic(int[] array) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                decreasing = false;
            }
            if (array[i] < array[i - 1]) {
                increasing = false;
            }
            if (!(increasing || decreasing)) {
                break;
            };
        }

        return increasing || decreasing;
    }
}
