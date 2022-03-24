package code.problems;

import java.util.Arrays;

public class GenerateBalancedParenthesis {

    public static void main(String[] args) {
        int n = 4;

        generate(n);
        System.out.println("Total: " + count);
    }

    private static void generate(int n) {

        char[] exp = new char[2 * n];

        gen(n, exp, 0, 0, 0);

    }

    static int count = 0;

    private static void gen(int n, char[] exp, int pos, int open, int close) {

        if (close == n) {
            count++;
            System.out.println(new String(exp));
            return;
        }

        System.out.println("Open "+ open + " " + close);
        if (open < n) {
            exp[pos] = '(';
            gen(n, exp, pos + 1, open + 1, close);
        }
        System.out.println("---- "+ open + " " + close);
        if (open > close) {
            exp[pos] = ')';
            gen(n, exp, pos + 1, open, close + 1);
        }
    }

}
