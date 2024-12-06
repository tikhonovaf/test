package sobes;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class DeletedNumber {
    public static void main(String[] args) {

        int[] intArr1 = {1, 5, 7, 12, 16};
        int[] intArr2 = {1, 5, 7, 16};

        int res = Arrays.stream(intArr1).sum() - Arrays.stream(intArr2).sum()  ;
        System.out.println(res);

    }
}
