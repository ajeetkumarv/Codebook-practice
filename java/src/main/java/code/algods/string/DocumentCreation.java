package code.algods.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DocumentCreation {
    public static void main(String[] args) {

        System.out.println("Possible? " + generateDocument("abcabc", "aabbccc"));
        System.out.println("Possible? " + generateDocument1("abcabc", "aabbccc"));

    }

    public static boolean generateDocument1(String characters, String document) {
        Set<Character> alreadyVisited = new HashSet<>();

        for (int i = 0;i< document.length();i++) {
            char character = document.charAt(i);

            if (alreadyVisited.contains(character)) {
                continue;
            }

            int docFreq = countCharFreq(character, document);
            int charFreq = countCharFreq(character, characters);

            if (docFreq > charFreq) {
                System.out.println("Character is short:" + character);
                return false;
            }

            alreadyVisited.add(character);
        }

        return true;
    }

    private static int countCharFreq(char character, String characters) {
        int count = 0;
        for ( char c: characters.toCharArray()) {
            if ( c == character)
                count++;
        }

        return count;
    }

    public static boolean generateDocument(String characters, String document) {

        if (document.equals("")) {
            return true;
        }

        Map<Character, Integer> charCnt = new HashMap<Character, Integer>();

        for (Character c: characters.toCharArray()) {
            charCnt.put(c, charCnt.getOrDefault(c, 0) + 1);
        }

        for (Character c: document.toCharArray()) {
            if (charCnt.get(c) == null || charCnt.get(c) == 0 ) {
                return false;
            }

            charCnt.put(c, charCnt.get(c) - 1);
        }

        return true;
    }
}
