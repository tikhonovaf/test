package collection;

import java.util.*;

public class LinkedListEx1 {

    public static void main(String[] args) {
        Deque<Integer> d = new ArrayDeque<>();

//        LinkedList<String> al = new LinkedList<>();

        d.addFirst(4);
        d.addLast(8);
        d.addFirst(2);
        d.add(1);
        d.add(7);

        System.out.println(d.peek());
        System.out.println(d);
        d.removeLast();
        d.pollLast();
        d.getFirst();
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
    }

}
