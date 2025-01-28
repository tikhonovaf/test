package sobes.strings;

import java.util.ArrayList;
import java.util.List;

//  ���������� ���������� ���� � ������
public class WordCounter {

    public static void main(String[] args) {

        String str = " �������� ���� ��  ";

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
                    //  �������� ����� �����
                    inWord = true;
                    wordsCount++;
                }
            } else {
                //  ��������� �����
                inWord = false;
            }
        }
        System.out.println("wordsCount - " + wordsCount);
    }
}
