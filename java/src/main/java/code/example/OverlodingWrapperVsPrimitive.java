package code.example;

/**
 * RULES
 * 1) Primitive Widening > Boxing > var args
 * 2) Widening and Boxing not allowed
 * 3) Boxed and Widening allowed
 * 4) wideing + varargs and boxing + varargs are mutually excusive to each other
 * 5) widening betweewn wrapper is not allowed
 * 6) Widening +  varargs and Boxing+varargs are individually allowed but not in overloaed version of method
 * 7) Boxing + widening > Boxing + varargs
 */
public class OverlodingWrapperVsPrimitive {
    public static void main(String[] args) {
        int primInt = 1;
        Integer wrapperInt = Integer.valueOf(1);
        fruit(primInt); // goes to primitive promoted to long
        fruit(wrapperInt); // goes to Integer var

        //car(wrapperInt); // NO PROMOTION
        //car(primInt); // NO PROMOTION

        long primLong = 1;
        color(primLong);

        // WIDENING OVER BOXING
        // AUTOBOXING Wins over downcast

        shape(wrapperInt);
    }

    private static void fruit(long var) {System.out.println("fruit long var");}
    private static void fruit(Integer var) {System.out.println("fruit Integer var");}

    private static void car(Long var) {System.out.println("car Long var");}

    private static void color(int var) {System.out.println("color int var");}
    private static void color(Long var) {System.out.println("color Long var");}

    private static void shape(long var) {System.out.println("shape long var");}

}
