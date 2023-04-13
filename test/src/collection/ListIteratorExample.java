package collection;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    public static void main(String[] args) {
        String s = "madam1";
        List<Character> list = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            list.add(ch);
        }
        ListIterator<Character> iterator = list.listIterator();
        ListIterator<Character> reversrIterator = list.listIterator(list.size());
        boolean isPaindrom = true;
        while (iterator.hasNext() && reversrIterator.hasPrevious()) {
            if (iterator.next() != reversrIterator.previous()) {
                isPaindrom = false;
            }
        }
        System.out.println(isPaindrom);


    }

}
