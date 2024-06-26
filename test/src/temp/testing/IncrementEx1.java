package temp.testing;


//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;




public class IncrementEx1 {
    private static int counter1 = 0;
    private static int counter2 = 0;
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static Integer counter4 = 0;

//    @PostConstruct
    public static void main(String ... arg) throws InterruptedException {
        int tasksCount = 100000;
        CountDownLatch latch = new CountDownLatch(tasksCount);
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for (int i = 0; i < tasksCount; i++) {
            executor.submit(() -> {
//                counter1++;
                synchronized (counter4) {
//                    counter4++;
                    counter1++;
                }
                counter2++;
                atomicInteger.incrementAndGet();
                latch.countDown();
            });
        }

        latch.await();
        System.out.println("latch.getCount() = " +latch.getCount());

        System.out.println(counter1);
        System.out.println(counter2);
        System.out.println(counter4);
        System.out.println(atomicInteger);
        System.exit(0);
    }
}

