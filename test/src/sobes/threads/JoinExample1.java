package sobes.threads;

import java.util.concurrent.CopyOnWriteArrayList;

public class JoinExample1 {
    static class Foo {
        final CopyOnWriteArrayList<String> out;

        Foo(CopyOnWriteArrayList<String> out) {
            this.out = out;
        }

        void first() {
            out.add("first");
        }

        void second() {
            out.add("second");
        }

        void third() {
            out.add("third");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        var out = new CopyOnWriteArrayList<String>();
        var foo = new Foo(out);
        var third = new Thread(
                () -> foo.third()
        );
        var second = new Thread(
                () -> {
                    try {
                        third.join();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    foo.second();
                }
        );
        var first = new Thread(
                () -> {
                    try {
                        second.join();
                    } catch (
                            InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    foo.first();
                }
        );
        first.start();
        second.start();
        third.start();
        first.join();
        second.join();
        third.join();

        System.out.println(out);
    }
}
