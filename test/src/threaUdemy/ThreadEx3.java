package threaUdemy;


public class ThreadEx3 {

    public static void main(String[] args) {
        new Thread(
                () -> {
                    for (int i = 1; i <= 1000; i++) {
                        System.out.println("MyThread1 " + i);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    for (int i = 1000; i > 0; i--) {
                        System.out.println("MyThread2 " + i);
                    }
                }
        ).start();

    }
}



