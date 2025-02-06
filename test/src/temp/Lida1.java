package temp;
import java.util.ArrayList;
import java.util.List;

    public class Lida1 {
            public static void main(String[] args) {
            String numSequence = "123456789";
            for (int targetSum = 1; targetSum <= 15; targetSum++) {
                List<String> expressions = generateExpressions(numSequence, targetSum);
                System.out.println("Target sum " + targetSum + ":");
                for (String expr : expressions) {
                    System.out.println(expr);
                }
            }
        }

            public static List<String> generateExpressions(String numSequence, int targetSum) {
            List<String> results = new ArrayList<>();
            helper(numSequence, targetSum, 0, 0, "", results);
            return results;
        }

            private static void helper(String numSequence, int targetSum, int index, int currentSum, String expr, List<String> results) {
            if (index == numSequence.length()) {
                if (currentSum == targetSum) {
                    results.add(expr);
                }
                return;
            }

            for (int i = index; i < numSequence.length(); i++) {
                String sub = numSequence.substring(index, i + 1);
                int num = Integer.parseInt(sub);

                if (index == 0) {
                    helper(numSequence, targetSum, i + 1, num, expr + num, results);
                } else {
                    helper(numSequence, targetSum, i + 1, currentSum + num, expr + "+" + num, results);
                    helper(numSequence, targetSum, i + 1, currentSum - num, expr + "-" + num, results);
                }
            }
        }
    }
