package code.feature;

public class StringOps {
    public static void main(String[] args) {
        System.out.println(">" + "  abc".indent(-2) + "<"); // adds new line at the end of str
        System.out.println(">" + "abc".indent(4) + "<");

        String transform = "Geekific".transform(value -> new StringBuilder(value).delete(4, 7).toString());
        System.out.println(transform);
    }
}
