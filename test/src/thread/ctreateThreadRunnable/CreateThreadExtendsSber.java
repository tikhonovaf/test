package thread.ctreateThreadRunnable;

class MyThreadSber extends Thread{
@Override
public void run(){
        System.out.println("Hello, I’m " + Thread.currentThread());
        }
        }
public class CreateThreadExtendsSber {
    public static void main(String[] args){
        MyThreadSber myThread = new MyThreadSber();
        myThread.start();
    }
}