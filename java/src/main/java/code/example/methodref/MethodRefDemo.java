package code.example.methodref;

public class MethodRefDemo {
    public MethodRefDemo(String msg, Integer num) {
        System.out.println("Constructor: " + msg + " " + num);
    }

    public static void show() {
        greet( (String msg, Integer n) -> new MethodRefDemo(msg, n));
        greet(MethodRefDemo::new);
    }

    public static void greet(Printer printer) {
        printer.print("a", 5);
    }

    public static void main(String[] args) {
        show();
    }
}
