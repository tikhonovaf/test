package sobes.threads;

import java.util.concurrent.*;

public class BackgroundThread {
    private static volatile boolean  stopRequsted ;

    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i =0;
                while (!stopRequsted) {
                    i++;
                    System.out.println(i);
                }
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequsted = true;
        backgroundThread.join();

        System.out.println(" End main");



    }
}
