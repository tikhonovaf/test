package sobes.common;

public class CountSubsequencesOptimized {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3, 3, 1, 3, 2, 3, 3}; // Пример последовательности
        int n = 5; // Длина подпоследовательности
        int x = 3; // Число, которое ищем
        int k = 3; // Минимальное количество вхождений числа x

        int result = countSubsequencesOptimized(a, n, x, k);
        System.out.println("Количество подходящих подпоследовательностей: " + result);
    }

    public static int countSubsequencesOptimized(int[] a, int n, int x, int k) {
        int count = 0;
        int occurrences = 0;

        // Инициализация окна
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                occurrences++;
            }
        }
        if (occurrences >= k) {
            count++;
        }

        // Скользящее окно
        for (int i = n; i < a.length; i++) {
            if (a[i - n] == x) {
                occurrences--;
            }
            if (a[i] == x) {
                occurrences++;
            }
            if (occurrences >= k) {
                count++;
            }
        }
        return count;
    }
}
