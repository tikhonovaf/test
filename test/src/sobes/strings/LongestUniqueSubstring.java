package sobes.strings;

import java.util.*;

public class LongestUniqueSubstring {


    public static int findLongestUniqueSubstring(String str) {
        int n = str.length();
        int maxLength = 0;
        int start = 0;
        String longestSubstring = "";

        for (int i = 0; i < n; i++) {
//            HashSet<Character> seen = new HashSet<>();
            List<Character> ls = new ArrayList<>();
            start = i;
            for (int j = i; j < n; j++) {
//                if (seen.contains(str.charAt(j))) {
//                    break;
//                }
                if (ls.contains(str.charAt(j))) {
                    break;
                }
                ls.add(str.charAt(j));
//                seen.add(str.charAt(j));
//                if (j - i + 1 > maxLength) {
//                    maxLength = j - i + 1;
//                    start = i;
//                    longestSubstring = str.substring(start, start + maxLength);
//                }
                maxLength = Math.max(j - i + 1, maxLength);
                longestSubstring = str.substring(start, start + j - i + 1);
                System.out.println(longestSubstring);
                System.out.println(maxLength);
                String s = "";
            }
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, set.size());
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String str = "abcabcbada";
        System.out.println("Самая длинная подстрока с неповторяющимися символами  1: " + findLongestUniqueSubstring(str));
        System.out.println("Самая длинная подстрока с неповторяющимися символами  2: " + lengthOfLongestSubstring(str));
    }
}

