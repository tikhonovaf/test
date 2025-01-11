package sobes.numbers;

import java.util.Arrays;

public class Intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        // Сортируем интервалы по их конечным точкам
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                // Если текущий интервал пересекается с предыдущим, увеличиваем счетчик
                count++;
            } else {
               // Обновляем конец текущего интервала
                end = intervals[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Intervals solution = new Intervals();
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println(solution.eraseOverlapIntervals(intervals));  // Вывод: 1
    }
}
