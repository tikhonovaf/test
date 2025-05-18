package sobes.common;

public class CountSubsequencesOptimized {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 3, 3, 1, 3, 2, 3, 3}; // ������ ������������������
        int n = 5; // ����� ���������������������
        int x = 3; // �����, ������� ����
        int k = 3; // ����������� ���������� ��������� ����� x

        int result = countSubsequencesOptimized(a, n, x, k);
        System.out.println("���������� ���������� ����������������������: " + result);
    }

    public static int countSubsequencesOptimized(int[] a, int n, int x, int k) {
        int count = 0;
        int occurrences = 0;

        // ������������� ����
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                occurrences++;
            }
        }
        if (occurrences >= k) {
            count++;
        }

        // ���������� ����
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
