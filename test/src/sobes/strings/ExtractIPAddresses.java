package sobes.strings;
import java.util.ArrayList;
import java.util.List;

public class ExtractIPAddresses {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a | b);


        int array[] = new int[0];

        int[] array1 = new int[1];

        int[] array2 = new int[1];

        int[] array3 = new int[] {1, 2};

        int[] array4 = {1, 2};

        String input = "0120050"; // ������ ������ � �������
        List<String> ipAddresses = extractIPAddresses(input);
        for (String ip : ipAddresses) {
            System.out.println(ip);
        }
    }

    public static List<String> extractIPAddresses(String input) {
        List<String> result = new ArrayList<>();
        int length = input.length();

        for (int i = 1; i < 4 && i < length - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < length - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < length; k++) {
                    String s1 = input.substring(0, i);
                    String s2 = input.substring(i, j);
                    String s3 = input.substring(j, k);
                    String s4 = input.substring(k);
                    if (isValidSegment(s1) && isValidSegment(s2) && isValidSegment(s3) && isValidSegment(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValidSegment(String segment) {
        if (segment.length() > 3 || segment.length() == 0) {
            return false;
        }
        if (segment.charAt(0) == '0' && segment.length() > 1) {
            return false;
        }
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }

}
