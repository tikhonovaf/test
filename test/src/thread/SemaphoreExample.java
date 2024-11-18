package thread;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class SemaphoreExample  extends Thread {

    private Semaphore sem;

    // ���� �� �������
    private boolean full = false;

    private String name;

    SemaphoreExample(Semaphore sem, String name) {
        this.sem = sem;
        this.name = name;
    }

    public void run() {
        try {
            // ���� ������� ��� �� ��
            if (!full) {
                //����������� � �������� ���������� �� ����������
                sem.acquire();
                System.out.println(name + " ������� �� ����");

                // ������� ���
                sleep(300);
                full = true;

                System.out.println(name + " ����! �� ������� ��-�� �����");
                sem.release();

                // ������� ����, ��������� ����� ������
                sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("���-�� ����� �� ���!");
        }
    }
}
    class Main {

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);
        new SemaphoreExample(sem,"������").start();
        new SemaphoreExample(sem,"������").start();
        new SemaphoreExample(sem,"����������").start();
        new SemaphoreExample(sem,"�����").start();
        new SemaphoreExample(sem,"�������").start();
    }
}
