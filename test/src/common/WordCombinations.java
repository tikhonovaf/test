package common;

import java.util.ArrayList;
import java.util.List;

public class WordCombinations {
    public static void main(String[] args) {
        String[] words = {"на", "место", "дерево"};
        List<String> combinations = generateCombinations(words);

        System.out.println(combinations);
    }

    public static List<String> generateCombinations(String[] words) {
        List<String> combinations = new ArrayList<>();
        combinations.add(""); // Ќачальна€ пуста€ строка

        for (String word : words) {
            List<String> newCombinations = new ArrayList<>();
            for (String combination : combinations) {
                for (char c : word.toCharArray()) {
                    newCombinations.add(combination + c);
                }
            }
            combinations = newCombinations;
        }

        return combinations;
    }
}

