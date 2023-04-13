package testing;

public class SberTest1 {
    public static void main(String[] args) {

   Parent p = new Child();
   p.test();

   Child c = new Child();
   c.test1();

    }
}

class Parent {

    public void test() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    public void test() {
        System.out.println("Child");
    }

    public void test2() {
        System.out.println("Child_2");
        }

    public void test1() {
        System.out.println("Child_1");
    }

}
