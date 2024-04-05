package common;

import java.util.ArrayList;
import java.util.List;

public class FinalExample {
    private final List foo;

    public FinalExample()
    {
        foo = new ArrayList();
        foo.add("foo");
    }
    public static void main(String[] args)
    {
        FinalExample t = new FinalExample();
        t.foo.add("bar");
        System.out.println("print - " + t.foo);
    }

}
