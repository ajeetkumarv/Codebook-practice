package code.learning.exception;

/**
 * this causes Error: Generic class may not extend 'java.lang.Throwable'
 * https://stackoverflow.com/questions/501277/why-doesnt-java-allow-generic-subclasses-of-throwable
 *
 *
 * because runtime info is erased, how will it decine on which catch block to go
 *
 * @param <T>
 */
public class MyException<T> { //extends Exception {
}

class Demo {
    void testMethod() {
        try {
            doSomeStuff();
        } catch(IllegalStateException e) {
            //Just anything
        } /* catch (MyException<Integer> e) { <--- this one
            // ignore that
        } catch (MyException<String> e) { <--- or this one
            //crashAndBurn()
        } */
    }

    void doSomeStuff() {

    }
}