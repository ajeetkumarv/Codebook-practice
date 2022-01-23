package code.example;

class A {
    int method() { return 0;}
}

class B extends A {
    //short method() { return 0;} // type promotion is not applied here
}

/**
 * https://www.youtube.com/watch?v=a_BoqsnVR2U&list=WL&index=3
 * https://www.baeldung.com/java-threadlocal
 * https://stackoverflow.com/questions/817856/when-and-how-should-i-use-a-threadlocal-variable
 *
 */
public class ThreadLocalDemo {

    public static void main(String[] args) {
        // can we create collection of Threadocal class
        //There is something called InheritableThreadLocal

        ThreadLocal<Integer> intLocal = ThreadLocal.withInitial(() -> 0);
        ThreadLocal<Integer> intLocal2 = new ThreadLocal<>() {
            @Override
            protected Integer initialValue() { // if I use int as return type it doesn't work
                //https://stackoverflow.com/questions/27701092/in-java-is-it-possible-to-override-methods-if-return-types-are-respectively-a-p
                return 0;
            }
        };

        InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<>();
    }

}
