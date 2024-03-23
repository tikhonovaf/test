package testing;

public class SberTest3 {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();


        a.draw();
        a.draw1();



        b.draw();
        b.draw1();
        b.draw2();



        a = b; //!!!!!

        a.draw();
        a.draw1();
        B b1  = (B) a;
        b1.draw2(); // !!!!


    }
}

class A {
    public void draw() {
        System.out.println("0");
    }
    public void draw1() {
        System.out.println("1 parent");
    }
}

class B extends A {
    public void draw1() {
        System.out.println("1 child");
    }
    public void draw2() {
        System.out.println("2");
    }
}
