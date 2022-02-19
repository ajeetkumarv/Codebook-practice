package code.problem;

import org.junit.jupiter.api.Test;

public class StringBased {
    @Test
    public void reverseString() {
        String str = "Geeks";
        int i = -1;
        int j = str.length();

        char[] rev = str.toCharArray();

        while(i++ < j--) {
            char tmp = rev[i];
            rev[i] = rev[j];
            rev[j] = tmp;
        }

        System.out.println("Reversed: " + String.valueOf(rev));
    }

}
