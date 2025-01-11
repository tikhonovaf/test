package sobes.collections;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseSchedule {
/*
Имеется n различных онлайн-курсов, пронумерованных от 1 до n. Вам дан массив courses, где courses[i] = [durationi, lastDayi]
 указывает, что i-й курс должен быть пройден непрерывно в течениеi дней и должен быть закончен до или в lastDayi.
 Вы начинаете в 1-й день и не можете проходить два или более курсов одновременно.
 Верните максимальное количество курсов, которые вы можете пройти.

 Для решения этой задачи на Java можно использовать жадный алгоритм с приоритетной очередью (PriorityQueue).

Этот код сначала сортирует курсы по дате окончания.
Затем он использует приоритетную очередь для отслеживания длительности курсов, которые были выбраны.
Если текущий курс можно пройти до его крайнего срока, он добавляется в очередь.
Если нет, но его длительность меньше, чем у самого длинного курса в очереди, он заменяет этот курс.
*/

    public int scheduleCourse(int[][] courses) {
// Сортируем курсы по дате окончания
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;

        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];

            if (time + duration <= lastDay) {
                pq.offer(duration);
                time += duration;
            } else if (!pq.isEmpty() && pq.peek() > duration) {
                time += duration - pq.poll();
                pq.offer(duration);
            }
        }

        return pq.size();
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
        System.out.println(cs.scheduleCourse(courses)); // Output: 3
    }

}
