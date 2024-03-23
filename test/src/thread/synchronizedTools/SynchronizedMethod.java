package thread.synchronizedTools;


public class SynchronizedMethod {
    Integer counterValue = 0;

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.decrement();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        thread2.join();
        System.out.println(counter.getValue());
    }

        public static class Counter {
            private int value;
            public int getValue() {
                return value;
            }
            public synchronized void increment() {
                value++;
            }
            public synchronized void decrement() {
                value--;
            }
        }

    }


