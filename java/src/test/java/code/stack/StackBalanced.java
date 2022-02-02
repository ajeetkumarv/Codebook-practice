package code.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class StackBalanced {

    boolean[] exp = {true,
            false,
            true,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            false,
            false,
            true,
            true,
            true,
            true};

    @Test
    public void test() {
        String data = "[({})(())]\n" +
                "(({()})))[[\n" +
                "({(){}()})()({(){}()})(){()}{}((()))\n" +
                "{}()))(()()({}}{}\n" +
                "}}}}\n" +
                "))))\n" +
                "{{{\n" +
                "(((\n" +
                "{}(){()}((())){{{}}}{()()}{{}{}}\n" +
                "{{{{{{{)))))))))))))))))))\n" +
                "{}{}(\n" +
                "{}}}{}\n" +
                "()()()())))\n" +
                "(((((()()()\n" +
                "(){}{{}}()(()){{()()}}\n" +
                "{}{{{}}}{{{((()))}}}\n" +
                "((()))[]\n" +
                "{{}}(()[])";

        String[] token = data.split("\n");

        for (int i=0;i< token.length;i++) {
            System.out.println(token[i] + " " + exp[i] + " " + isBalanced(token[i]));
        }
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c: input.toCharArray()) {
            if (c == '(' || c =='{' || c == '[') {
                stack.push(c);
            } else if ((c == ')' || c =='}' || c == ']') && stack.empty()) { // I really missed this thing
                return false;
            } else if (!stack.empty()){
                stack.pop();
            }
        }

        return stack.empty();

    }
}
