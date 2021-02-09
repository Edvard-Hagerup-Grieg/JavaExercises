// Простые задачи на строки.

import java.util.ArrayList;

public class Exercises_Strings {

    // Напишите метод для поиска самой длинной строки в массиве.
    public static String getLongestString(ArrayList<String> stringArray) {
        int maxLength = 0;
        String maxString = null;
        for(String string : stringArray) {
            if(string.length() > maxLength) {
                maxLength = string.length();
                maxString = string;
            }
        }

        return maxString;
    }

    // Напишите метод, который проверяет является ли слово палиндромом.
    public static boolean isPalindrome(String string) {
        boolean answer = true;
        char[] charArray = string.toCharArray();

        int shift = 0;
        int halfLength = charArray.length / 2;
        while(shift < halfLength) {
            if(charArray[shift] != charArray[charArray.length - shift - 1]) {
                answer = false;
                break;
            }
            shift++;
        }

        return answer;
    }

    // Напишите метод, заменяющий в тексте все вхождения слова «бяка» на «[вырезано цензурой]».
    public static ArrayList<String> censor(ArrayList<String> text, String forbiddenWord) {
        ArrayList<String> censoredText = new ArrayList<String>();
        for(String word : text) {
            if(word.equals(forbiddenWord)) {
                censoredText.add("[censored]");
            } else {
                censoredText.add(word);
            }
        }
        return censoredText;
    }


    private static int containsIteration(String string1, String string2, int num) {
        int idx = string1.indexOf(string2);
        if(idx >= 0) {
            num = containsIteration(string1.substring(idx + string2.length()), string2, ++num);
        }
        return num;
    }

    // Напишите метод, возвращающий количество вхождений одной строки в другую.
    public static int numberOfRepetition(String string1, String string2) {
        return containsIteration(string1, string2, 0);
    }



    public static void main(String[] args) {
        ArrayList<String> stringArray = new ArrayList<String>();

        stringArray.add("Clara");
        stringArray.add("has");
        stringArray.add("stolen");
        stringArray.add("corals");
        stringArray.add("from");
        stringArray.add("Carl");
        stringArray.add("and");
        stringArray.add("Carl");
        stringArray.add("has");
        stringArray.add("stolen");
        stringArray.add("a");
        stringArray.add("clarinet");
        stringArray.add("from");
        stringArray.add("Clara");

        System.out.println(stringArray);
        System.out.println(String.format("The longest word is \"%s\"", getLongestString(stringArray)));
        System.out.println();


        System.out.print("The word \"MADAM\" is ");
        if(!isPalindrome("MADAM"))
            System.out.print("not ");
        System.out.println("palindrome.");

        System.out.print("The word \"SUMMUS\" is ");
        if(!isPalindrome("SUMMUS"))
            System.out.print("not ");
        System.out.println("palindrome.");

        System.out.print("The word \"ADAM\" is ");
        if(!isPalindrome("ADAM"))
            System.out.print("not ");
        System.out.println("palindrome.");

        System.out.println();


        System.out.println("The text after censoring with forbidden word \"stolen\":");
        System.out.println(censor(stringArray, "stolen"));
        System.out.println();

        String testString = "1_clarinet_2_clarinet_3_clarinet_4_clarinet";
        System.out.println("String \"" + testString +
                String.format("\" conteins %d repetitions of word \"clarinet\".", numberOfRepetition(testString, "clarinet")));
    }
}
