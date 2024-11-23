package common;

public class ClosureExample {
    public static void main(String args[]) {
        int x = 20;
        int y = 90;
//the method parses two parameters i.e. x and the operate() method of the Operation interface
//implementation of closure in lambda expression
        doSum(x, new Operation() {
            //overrides the operate() method
            @Override
            public void operate(int n) {
//prints the result
                System.out.println("Sum is: " + (n + y));
            }
        });
    }

    private static void doSum(int i, Operation op) {
        op.operate(i);
    }
}
