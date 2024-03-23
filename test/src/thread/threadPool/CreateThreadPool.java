package thread.threadPool;


import java.util.concurrent.*;

public class CreateThreadPool {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 30; i++) {
//            executorService.execute(new Task(i));
            executorService.submit(new Task(i));
        }

        executorService.shutdown();
        executorService.awaitTermination(15, TimeUnit.SECONDS);
    }
}

// Класс для создания потока
class Task implements Runnable {
    int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
//            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Обработан запрос пользователя №" + taskNumber + " на потоке " + Thread.currentThread().getName());
    }
}




