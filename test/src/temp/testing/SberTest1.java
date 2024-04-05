package temp.testing;

public class SberTest1 {
    public static void main(String[] args) {

        Parent p = new Parent();
        p.test();
        System.out.println(p.sp);

        Parent p1 = new Child();
        ((Child)p).test();

        Child c = new Child();
        c.test();

        Parent c1 =   p;
        c1.test();

    }
}

class Parent {
    String sp = "str_p";
    public void test() {
        System.out.println("Parent");
    }

}

class Child extends Parent {
    String sp = "str_ch";
    @Override
    public void test() {
        System.out.println("Child");
    }

}
