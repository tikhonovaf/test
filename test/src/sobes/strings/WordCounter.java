package sobes.strings;

import java.util.ArrayList;
import java.util.List;

//  Определяем количество слов в строке
public class WordCounter {

    public static void main(String[] args) {

        String str = " Проверка слов ке  ";

        int wordsCount = 0;
        System.out.println("wordsCount - " + wordsCount);

        String a = "Hello";
        String b = "Hello";

        a = "Word";

        List<String> ls = new ArrayList();

        Boolean inWord = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c) || c == '-') {
                if (!inWord) {
                    //  Начинаем новое слово
                    inWord = true;
                    wordsCount++;
                }
            } else {
                //  завершаем слово
                inWord = false;
            }
        }
        System.out.println("wordsCount - " + wordsCount);
    }
}
