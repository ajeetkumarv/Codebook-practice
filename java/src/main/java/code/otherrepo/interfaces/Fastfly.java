package code.otherrepo.interfaces;

/**
 * RULE1/4: Methods are automatically INHERITED  
 * RULE2/4: default method can be OVERRIDEN
 * RUlE3/4: if any default method is found to be anywhere in hierarchy in classes, that gets the preference
 *      anywhere, even if at the very top class and grand child classes implement interfaces
 *      class version gets the preference
 * RULE4/4: if there is collision, class will have to override and provide uses using Sail.super.method()
 */
public interface Fastfly extends Fly {
    default void takeoff() {
        System.out.println("Fastfly: takeoff");
    }
}
