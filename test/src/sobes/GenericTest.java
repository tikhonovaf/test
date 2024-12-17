package sobes;

import java.util.ArrayList;
import java.util.List;

// PECS provider extends, consumer super
public class GenericTest {
    public static void main(String[] args) {
        List< ? extends Fruit > fruitsExt = new ArrayList<>();
        List< ? super Fruit > fruitsSuper = new ArrayList<>();
        List< Fruit > fruitsSuper2 = new ArrayList<>();


        fruitsSuper.add(new Fruit());
        fruitsSuper.add(new AppleExt());
        fruitsSuper.add(new AppleExt());
        fruitsSuper.add(new AppleExt());

        fruitsSuper.get(0);
        fruitsExt.get(1);

    }
}


class Simple {

}


class Fruit extends Simple{

}

class Apple extends Fruit{

}

class AppleExt extends Apple{

}


class Orange extends Fruit{

}