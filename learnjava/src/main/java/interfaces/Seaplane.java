package interfaces;

public class Seaplane extends Vehicle implements Fastfly, Sail {

    //There will be no problem for not implementing chappu because that is not in collision anywhere

    //ERROR that forces to override cruise is
    //interfaces.Seaplane inherits unrelated defaults for cruise() from types interfaces.Fly and interfaces.Sail

    @Override
    public void cruise() {
        Sail.super.cruise();
        // Using super because if we write Sail.cruise() interface can have static methods also
        Sail.staticMethod();
    }


    // commented to check how it behaves when called from Fly reference
    /*@Override
    public String toString() {
        return "Seaplane{}";
    }*/
}
