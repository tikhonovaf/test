package thread.lockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) throws InterruptedException {
        Call call = new Call();
        Thread newThreadMobileCall = new Thread(
                () -> {
                    call.mobileCall();
                }
        );
        Thread newThreadSkypeCall = new Thread(
                () -> {
                    call.skypeCall();
                }
        );
        Thread newThreadWhatsapCall = new Thread(
                () -> {
                    call.whatsapCall();
                }
        );
        newThreadMobileCall.start();
        newThreadSkypeCall.start();
        newThreadWhatsapCall.start();

//        newThreadSkypeCall.interrupt();

    }
}

class Call {
    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        try {
//            lock.lock();
            System.out.println(("Mobile call starts  " + Thread.currentThread().getName()));
            Thread.sleep(3000);
            System.out.println(("Mobile call ends"));
        } catch (InterruptedException e) {
            System.out.println("Mobile call interrupted");
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
            System.out.println("whatsap call interrupted");
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
            System.out.println("Skype call interrupted");
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
