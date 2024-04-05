package temp.testing;

// Java program to demonstrate
// Upcasting Vs Downcasting

import lombok.Data;

// Parent class
@Data
class Parent1 {
    private  String name;

    // A method which prints the
    // signature of the parent class
    void method()
    {
        System.out.println("Method from Parent");
    }
}

// Child class
@Data
class Child1 extends Parent1 {
    private int id;

    // Overriding the parent method
    // to print the signature of the
    // child class
    @Override void method()
    {
        System.out.println("Method from Child");
    }
}

// Demo class to see the difference
// between upcasting and downcasting
 class GFG2 {

    // Driver code
    public static void main(String[] args)
    {
        // Upcasting
        Parent1 p = new Child1();
//        Parent1 p = new Parent1();
        p.setName("GeeksforGeeks Parent");

        //Printing the parentclass name
        System.out.println(p.getName());
        //parent class method is overridden method hence this will be executed
        p.method();

        // Trying to Downcasting Implicitly
        // Child c = new Parent(); - > compile time error

        // Downcasting Explicitly
        Child1 c = (Child1)p;

        c.setId(1);
        System.out.println(c.getName());
        System.out.println(c.getId());
        c.method();
    }
}
