package threaUdemy;


import java.util.concurrent.ConcurrentHashMap;

public class ThreadEx2 {

    public static void main(String[] args) {
        Thread myThread3 = new Thread(new MyThread3());
        Thread myThread4 = new Thread(new MyThread4());
        myThread3.start();
        myThread4.start();
        ConcurrentHashMap<Integer,String> chm = new ConcurrentHashMap<>();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 1000; i++) {
                    System.out.println("MyThread1 " + i);
                }
            }
        };
    }
}

    class MyThread3 implements Runnable {
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("MyThread1 " + i);
            }
        }
    }

    class MyThread4 implements Runnable{
        public void run() {
            for (int i = 1000; i > 0; i--) {
                System.out.println("MyThread2 " +i);
            }
        }
    }


