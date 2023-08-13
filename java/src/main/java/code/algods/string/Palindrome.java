package code.algods.string;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abccba"));
        System.out.println(isPalindrome("abcdba"));

        System.out.println(isPalindrome("abccba", 0));
        System.out.println(isPalindrome("abcdba", 0));
    }

    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isPalindrome(String str, int i) {
        int j = str.length() - 1 -i;
        return i >=j ? true : str.charAt(i) == str.charAt(j) && isPalindrome(str, i + 1);
    }
}
