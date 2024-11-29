package temp.testing;

public class ThreadDemo {
    private int count = 1;
    public synchronized void doSomething()
    {
        for (int i = 0; i < 10; i++) {
            System.out.println(count++);
        }
    }

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        Thread a1 = new A1 (demo);
        Thread a2 = new A1 (demo);
        a1.start();
        a2.start();
    }
}

class A1 extends Thread {
    ThreadDemo demo;
    public A1 (ThreadDemo td) {
        demo = td;
    }
    public void run() {
        demo.doSomething();
    }
}