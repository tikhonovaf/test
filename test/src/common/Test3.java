package common;

interface A {
    int diff(int x, int y);
}

class B implements A {
    public int diff(int x, int y) {
        return x - y;
    }

    public int sum(int x, int y) {
        return x + y;
    }
}

class C extends B {
    public int mult(int x, int y) {
        return x * y;
    }

    public int diff(int x, int y) {
        return y - x;
    }
}

class Test3 {
    public static void main(String[] args) {

        A aB = new B();
        A aC = new C();
        B bB = new B();
        B bC = new C();
        C cC = new C();

    }
}
