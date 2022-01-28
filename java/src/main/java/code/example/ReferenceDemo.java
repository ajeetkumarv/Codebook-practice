package code.example;

import java.lang.ref.WeakReference;

/**
 * there can be below type of references
 * Strong
 * weak
 * soft
 * phantom
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        StringBuilder b = new StringBuilder();
        b.append("Apple");
        System.out.println(">"+ b);
        WeakReference<StringBuilder> builder = new WeakReference<>(b);


    }
}
