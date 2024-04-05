package thread.lockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        Call call = new Call();
        Thread newThread1 = new Thread(
                () -> {
                    call.mobileCall();
                }
        );
        Thread newThread2 = new Thread(
                () -> {
                    call.skypeCall();
                }
        );
        Thread newThread3 = new Thread(
                () -> {
                    call.whatsapCall();
                }
        );
        newThread1.start();
        newThread2.start();
        newThread3.start();

    }
}

class Call {
    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        try {
            System.out.println(("Mobile call starts"));
            Thread.sleep(3000);
            System.out.println(("Mobile call ends"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    void whatsapCall() {
        lock.lock();
        try {
            System.out.println(("whatsap call starts"));
            Thread.sleep(3000);
            System.out.println(("whatsap call ends"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    void skypeCall() {
        lock.lock();
        try {
            System.out.println(("Skype call starts"));
            Thread.sleep(3000);
            System.out.println(("Skype call ends"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
