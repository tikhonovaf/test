package thread.ctreateThreadRunnable;



public class CreateThreadExtends {

    public static void main(String ... args) {
        MyThread01 myThread01 = new MyThread01();
        MyThread02 myThread02 = new MyThread02();
        myThread01.start();
        myThread02.start();

    }
}

class MyThread01 extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("MyThread1 " + i);
        }
    }
}

class MyThread02 extends Thread {
    public void run() {
        for (int i = 100; i > 0; i--) {
            System.out.println("MyThread2 " +i);
        }
    }
}

