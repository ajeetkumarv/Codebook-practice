package code.example.interfaces;

/**
 * RULE1/4: Methods are automatically INHERITED
 * RULE2/4: default method can be OVERRIDEN
 * RUlE3/4: if any default method is found to be anywhere in hierarchy in classes, that gets the preference
 *      anywhere, even if at the very top class and grand child classes implement interfaces
 *      class version gets the preference
 * RULE4/4: if there is collision, class will have to override and provide uses using Sail.super.method()
 */

/*
abstract class can have states is the major distinction


 */
public class Run {
    public static void main(String[] args) {
        Seaplane seaplane = new Seaplane();
        seaplane.takeoff();
        seaplane.cruise();

        Fly fly = new Seaplane();

        /*
        * NOTICE this, Fly is an interface and we are using toString()
        * it prints interfaces.Seaplane@7c75222b if not implemented in Seaplane
        *
        */
        System.out.println(fly.toString());
    }
    
}
