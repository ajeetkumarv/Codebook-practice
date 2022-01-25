package code.problems;

import java.util.Stack;

public class ReplaceCharNested {

    public static void main(String[] args) {
        String data = "How @ are (you @ do(ok@ok)ing) today @.";
        data = "How @ are (@20210215 (sample@sample.com) active) doing@today";
        char candidate = '@';
        char replacement = '#';
        boolean replaceFlag = true;

        Stack<Character> stack = new Stack<>();

        StringBuilder newData = new StringBuilder();

        for (char c: data.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                replaceFlag = false;
            } else if (c == ')') {
                stack.pop();
            }

            if (stack.isEmpty()) {
                replaceFlag = true;
            }

            if (c == candidate && replaceFlag) c = replacement;

            newData.append(c);
        }

        System.out.println("Old data: "+ data);
        System.out.println("New data: "+ newData);
    }

}
