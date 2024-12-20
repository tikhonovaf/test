package sobes;

public class UnlimitedFor {
    public static final int END = Integer.MAX_VALUE;
//    public static final int END = 500;
    public static final int START = END - 10;

    public static void main(String[] args) {
        int count = 0;
//        int result = Integer.MAX_VALUE - 100;
//        System.out.println(Integer.MAX_VALUE); // 2147483547
//        System.out.println(result); // 2147483547

        for (int i = START; i <= END; i++)
            count++;
        System.out.println(count);
    }

}
