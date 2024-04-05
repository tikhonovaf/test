package thread.syncClasses;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException {
        int tasksCount = 100_000;
        CountDownLatch latch = new CountDownLatch(tasksCount);
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < tasksCount; i++) {
            executor.submit(() -> {
                latch.countDown();
                counter2++;
                counter1++;
            });
        }

        latch.await();
        System.out.println("latch.getCount() = " + latch.getCount());

        System.out.println(counter1);
        System.out.println(counter2);
        System.exit(0);
    }
}


