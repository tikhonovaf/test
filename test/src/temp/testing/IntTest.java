package temp.testing;

public class IntTest {
    public static void main(String[] args)
    {
        Sedan sedan = new Sedan();
        sedan.gas(" test ");
        System.out.println(sedan.gas(" test "));
        System.out.println(sedan.s1);
    }

}

interface Car {
    String s1 = "Статическая переменная";
    public default String gas(String s) {
        return "Газ:::" + s;
    }

    public default void brake() {
        System.out.println("Тормоз!");
    }
}

class Sedan implements Car {

}

class Truck implements Car {

}

class F1Car implements Car {

}

