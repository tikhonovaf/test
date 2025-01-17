package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteTest {

    public static void main(String[] args) {
        // Create a new ExecutorService with a single thread
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Create a Runnable object
        Runnable task1 = new Runnable() {
            public void run() {
                System.out.println("Hello, world _1!");
            }
        };

        Runnable task2 = new Runnable() {
            public void run() {
                System.out.println("Hello, world _2!");

            }
        };

// Submit the task to the ExecutorService
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task1);

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task1);

// Shutdown the ExecutorService
        executorService.shutdown();
    }
}
