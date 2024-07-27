package algo.stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ShortenedPath {
    public static void main(String[] args) {
        String path = "/foo/../test/../test/../foo//bar/./baz";

        //theirSolution(path);
        System.out.println(mySolution(path));
        System.out.println(mySolution("../../foo/../../bar/baz"));
    }

    private static String mySolution(String path) {
        boolean isFromRoot = path.charAt(0) == '/';

        String[] tokenArr = path.split("/");
        List<String> tokens = Arrays.stream(tokenArr)
                .filter(t -> !t.equals(".") && !t.equals(""))
                .toList();

        System.out.println("Tokens: " + tokens);

        Stack<String> stack = new Stack<>();

        for (String dir: tokens) {
            if (!dir.equals("..")) {
                stack.push(dir);
                continue;
            }

            if(isFromRoot) {
                if (stack.isEmpty()) {
                    //do nothing
                } else if (stack.peek().equals("..")) {
                    stack.push(dir);
                } else {
                    stack.pop();
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(dir);
                } else if (stack.peek().equals("..")) {
                    stack.push(dir);
                } else {
                    stack.pop();
                }
            }
        }

        return (isFromRoot ? "/" : "") + String.join("/", stack);
    }

    private static void theirSolution(String path) {
        boolean startsWithPath = path.charAt(0) == '/';

        String[] tokenArr = path.split("/");

        List<String> tokenList = Arrays.asList(tokenArr);
        tokenList = tokenList.stream().filter(t -> isImpToken(t)).collect(Collectors.toList());

        Stack<String> stack = new Stack<>();

        if (startsWithPath) stack.add("");

        for (String token: tokenArr) {
            if (token.equals("..")) {
                if (stack.size() == 0 || stack.peek().equals("..")) {
                    stack.add(token);
                } else if(!stack.peek().equals("")) {
                    stack.pop();
                }
            } else {
                stack.add(token);
            }
        }

        if (stack.size() == 1)
            System.out.println("/");
        else
            System.out.println(String.join("/", stack));
    }

    public static boolean isImpToken(String token) {
        return token.length() > 0 && !token.equals(".");
    }

}
