package sobes.collections;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseSchedule {
/*
������� n ��������� ������-������, ��������������� �� 1 �� n. ��� ��� ������ courses, ��� courses[i] = [durationi, lastDayi]
 ���������, ��� i-� ���� ������ ���� ������� ���������� � �������i ���� � ������ ���� �������� �� ��� � lastDayi.
 �� ��������� � 1-� ���� � �� ������ ��������� ��� ��� ����� ������ ������������.
 ������� ������������ ���������� ������, ������� �� ������ ������.

 ��� ������� ���� ������ �� Java ����� ������������ ������ �������� � ������������ �������� (PriorityQueue).

���� ��� ������� ��������� ����� �� ���� ���������.
����� �� ���������� ������������ ������� ��� ������������ ������������ ������, ������� ���� �������.
���� ������� ���� ����� ������ �� ��� �������� �����, �� ����������� � �������.
���� ���, �� ��� ������������ ������, ��� � ������ �������� ����� � �������, �� �������� ���� ����.
*/

    public int scheduleCourse(int[][] courses) {
// ��������� ����� �� ���� ���������
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
