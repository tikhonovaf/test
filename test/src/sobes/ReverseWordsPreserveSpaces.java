package sobes;

public class ReverseWordsPreserveSpaces {
        public static void main(String[] args) {
            String orig = "  I  love  study   Java";
            String goal = "";
            String[] words = orig.split("\\s+");

            for (int i = words.length - 1; i >= 0; i--) {
                goal += words[i] + " ";
            }

            System.out.println(goal);
        }    }
