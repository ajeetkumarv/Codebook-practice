package algo.string;

public class RunLengthCompression {

    public static void main(String[] args) {
        System.out.println("Result: " + runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }

    public static String runLengthEncoding(String string)  {

        StringBuilder sb = new StringBuilder();

        int length = 1;

        for (int i = 1; i< string.length(); i++) {
            char curr = string.charAt(i);
            char prev = string.charAt(i-1);

            if (curr != prev || length == 9) {
                sb = sb.append(length);
                sb = sb.append(prev);
                length = 0;
            }

            length++;
        } // for loop ends

        sb = sb.append(length + String.valueOf(string.charAt(string.length() - 1)));

        return sb.toString();
    }

}
