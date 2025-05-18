package sobes.strings;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StringEquals {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "aaa";
        s2 = s2 + "лллл";
        String s3 = new String("aaa");
        String s4 = new String("aaa").intern();
        String s5 = String.valueOf("aaa");

        System.out.println((s1==s2));
        System.out.println((s1==s3));
        System.out.println((s1==s4));
        System.out.println((s1==s5));

    }
}
