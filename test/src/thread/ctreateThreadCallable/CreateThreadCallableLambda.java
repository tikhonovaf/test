package thread.ctreateThreadCallable;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CreateThreadCallableLambda {

    public static void main(String []args) throws Exception {
        Callable task = () -> {
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future, "thread name").start();
        System.out.println(future.get());
    }
}


