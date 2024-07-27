package algo.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar1("abcbded"));
        firstNonRepCharMap("abcbded");
    }

    private static int firstNonRepeatingChar1(String str) {
        for (int i = 0;i<str.length();i++) {
            boolean dupFound = false;
            for(int j=0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && ( j != i)) {
                    dupFound = true;
                    break;
                }
            }

            if (!dupFound)
                return i;
        }

        return -1;
    }

    private static void firstNonRepCharMap(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c: str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c: str.toCharArray()) {
            if (1 == charCount.get(c)){
                System.out.println("First non repeating char is: " + c);
                return;
            }
        }

        System.out.println("No non repeating char found");
    }
}
