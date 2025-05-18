package sobes.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class StackTest {
    public static void main(String[] args) {
        Deque<String> stack = new ArrayDeque<>();
        stack.push("first");
        stack.push("second");

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        Deque<String> queue = new ArrayDeque<>();
        queue.offer("first");
        queue.offer("second");
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}
