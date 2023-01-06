import java.util.HashMap;
import java.util.Scanner;

public class LinkLastWordGame {

    static HashMap<String, Integer> wordMap = new HashMap<>();
    static int error = 0;
    static int ERROR_COUNT = 10;

    public static void main(String args[]) {

        Scanner word = new Scanner(System.in);

        while (error < ERROR_COUNT) {
            String inputWord = word.nextLine();

            if (checkDuplicate(inputWord)) {
                error++;
                System.out.println("중복 단어....! (" + (ERROR_COUNT- error) + "회 남음)");
            } else {
                error = 0;
                wordMap.put(inputWord, wordMap.getOrDefault(inputWord, 0) + 1);
            }
        }
    }

    // 중복 단어 체크
    public static Boolean checkDuplicate(String word) {
        return wordMap.containsKey(word);
    }
}
