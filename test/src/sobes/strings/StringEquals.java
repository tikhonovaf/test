package sobes.strings;

public class StringEquals {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        String s4 = new String("aaa").intern();
        String s5 = String.valueOf("aaa");

        System.out.println((s1==s2));
        System.out.println((s1==s3));
        System.out.println((s1==s4));
        System.out.println((s1==s5));

    }
}
