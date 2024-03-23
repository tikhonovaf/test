package thread.ctreateThreadRunnable;


public class CreateThreadRunnable {

    public static void main(String[] args) {
        // Первый параметр: экземпляр Runnable
        // Второй параметр: своё имя (необязательно)
        Thread myThread = new Thread(new MyThread(), "Leo");
        myThread.start();
    }

}

class MyThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("MyThread " + i);
        }
    }
}

// Пример прерывания потока
class MyThread1 implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // Код потока
        }
    }
}


