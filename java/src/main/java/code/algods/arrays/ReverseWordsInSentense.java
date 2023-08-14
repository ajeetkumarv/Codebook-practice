package code.algods.arrays;

public class ReverseWordsInSentense {
    public static void main(String[] args) {

        System.out.println(revUsingSplitAndJoin("This is ajeet kumar!   "));
        System.out.println(revUsingWordRevThenAllReverse("This is ajeet kumar!   "));

    }


    private static String revUsingWordRevThenAllReverse(String str) {
        char[] chars = str.toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            int spaceIndex = str.indexOf(" ", i);
            reverse(chars, i, spaceIndex - 1);

            spaceIndex += 1;//test for continous spaces

            while (spaceIndex <= j && chars[spaceIndex] == ' ') { spaceIndex++; }

            i = spaceIndex;
            System.out.println(chars);
        }

        reverse(chars);
        return String.valueOf(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }

    private static void reverse(char[] chars) {
        reverse(chars, 0, chars.length-1);
    }

    private static String revUsingSplitAndJoin(String str) {

        String[] words = str.split(" ", -1);

        int i=0, j=words.length-1;

        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;

            i++;
            j--;
        }

        return String.join(" ", words);
    }

    private static String revUsingStack() {
        return null;
    }
}