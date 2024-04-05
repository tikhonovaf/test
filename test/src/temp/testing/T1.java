package temp.testing;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class T1 {
    static List<Integer> eqEl = new ArrayList<>();
    public static void main(String[] vars) {
        int[] arr1 = new int[] {3, 5, 6, 14, 23, 23, 25, 29, 30, 33, 36, 40};
        int[] arr2 = new int[] {2, 3, 6, 7, 15, 21, 23, 26, 33, 39};
        for (int el1 : arr1)
        {
            for (int el2 : arr2)
            {
                if (el1 == el2)
                {
//                 Нужно добавить в массив
                    eqEl.add(el1);
                }
            }
        }
//  Выборка максимального значения из массива
        Integer max = 0;
        for (int i = 1; i < eqEl.size(); i++) {
            if (eqEl.get(i) > max) {
                max = eqEl.get(i) ;
            }
        }
        System.out.println("max = "  + max);

//        {3, 5, 6, 14, 23, 23, 25, 29, 30, 33, 36, 40}  {2, 3, 6, 7, 15, 21, 23, 26, 33, 39}

    }

    public String encrypt(String in) {
        if (in != null && !in.isEmpty()) {
            int strLen = in.length();
            String out = "";
            for (int i = 0; i < strLen; i++) {
                char outChar = (char) (in.substring(strLen - 1 - i, strLen - i).charAt(0) + strLen - i);
                out = out + outChar;
            }
            try {
                return Base64.getEncoder().encodeToString(out.getBytes("UTF8"));
            } catch (UnsupportedEncodingException e) {
                return "";
            }
        } else {
            return "";
        }
    }
}
