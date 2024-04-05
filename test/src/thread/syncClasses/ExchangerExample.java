package thread.syncClasses;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerExample {

        public static void main(String[] args) {

            Exchanger<String> ex = new Exchanger<String>();
            new Thread(new PutThread(ex)).start();
            new Thread(new GetThread(ex)).start();
        }
    }

    class PutThread implements Runnable{

        Exchanger<String> exchanger;
        String message;

        PutThread(Exchanger<String> ex){

            this.exchanger=ex;
            message = "Hello Java!";
        }
        public void run(){

            try{
                message=exchanger.exchange(message);
                System.out.println("PutThread has received: " + message);
            }
            catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
    class GetThread implements Runnable{

        Exchanger<String> exchanger;
        String message;

        GetThread(Exchanger<String> ex){

            this.exchanger=ex;
            message = "Hello World!";
        }
        public void run(){

            try{
                message=exchanger.exchange(message);
                System.out.println("GetThread has received: " + message);
            }
            catch(InterruptedException ex){
                System.out.println(ex.getMessage());
            }
        }
    }


