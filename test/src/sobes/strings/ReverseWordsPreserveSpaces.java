package sobes.strings;

public class ReverseWordsPreserveSpaces {
    public String reverseWords(String orig) {
        StringBuilder goal = new StringBuilder();
        String[] words = orig.trim().split("\\s+");

        for (int i = words.length - 1; i >= 1; i--) {
            goal = goal.append(words[i]).append(" ");
        }
        goal.append(words[0]);
        return goal.toString();
    }

    public static void main(String[] args) {
        String orig = "  I  love  study   Java";
//            String orig  = "the sky is blue";
//        String orig = "the";
//        StringBuilder goal = new StringBuilder();
//        String[] words = orig.split("\\s+");
//
//        for (int i = words.length - 1; i >= 0; i--) {
//            goal = goal.append(words[i]).append(" ");
//        }
        ReverseWordsPreserveSpaces rw = new ReverseWordsPreserveSpaces();
        System.out.println(rw.reverseWords(orig));

    }
}
