package sobes.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestUniqueSubstring {


    public static String findLongestUniqueSubstring(String str) {
        int n = str.length();
        int maxLength = 0;
        int start = 0;
        String longestSubstring = "";

        for (int i = 0; i < n; i++) {
            HashSet<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (seen.contains(str.charAt(j))) {
                    break;
                }
                seen.add(str.charAt(j));
                if (j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                    longestSubstring = str.substring(start, start + maxLength);
                }
            }
        }
        return longestSubstring;
    }


    public static int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> processedChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(1);
            if (processedChars.containsKey(c) && start <= processedChars.get(c)) {
                start = processedChars.get(c) + 1;
            } else {
                maxLength = Math.max(maxLength, i - start + 1);
            }
            processedChars.put(c, i);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabclb";
        System.out.println("Самая длинная подстрока с неповторяющимися символами: " + findLongestUniqueSubstring(str));
        System.out.println("Самая длинная подстрока с неповторяющимися символами 2: " + lengthOfLongestSubstring(str));
    }
}

