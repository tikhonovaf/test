package sobes;

public class threads {
    public static class GasPromThread {

            public synchronized void update(String text) {
                text = "abc" + text;
                System.out.println(text);
            }

            public synchronized void test() {
                String a = "123";
                update(a);
                System.out.println(a);
            }

            public static void main(String[] args) {
                Thread t1 = new Thread(() -> new GasPromThread().test());
                Thread t2 = new Thread(() -> new GasPromThread().test());
                t1.start();
                t2.start();
            }
        }
}
