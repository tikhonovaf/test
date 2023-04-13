package threaUdemy;

public class Sber1 {

   public static void main(String... args) {
            threaUdemy.MyThread11 myThread11 = new threaUdemy.MyThread11();
            threaUdemy.MyThread21 myThread21 = new threaUdemy.MyThread21();
            myThread11.start();
            myThread21.start();

        }
    }

    class MyThread11 extends Thread {
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                System.out.println("MyThread1 " + i);
            }
        }
    }

    class MyThread21 extends Thread {
        public void run() {
            for (int i = 1000; i > 0; i--) {
                System.out.println("MyThread2 " + i);
            }
        }
    }
