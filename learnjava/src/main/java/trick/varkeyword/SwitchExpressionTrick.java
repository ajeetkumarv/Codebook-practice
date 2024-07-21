package trick.varkeyword;

public class SwitchExpressionTrick {
    public static void main(String[] args) {
        int x = 0;

        //if we run this in jshell of jDK 13, this works and infers as int
        // very much like a method that returns int
        var y = switch(x) {case 0 -> 0; default -> -1;};

        //the type of y2 infered is gonna be very very interesting using /v
        //it's complex combination of Comparable and internal java classes like
        //java.lang.constable.Constable and other
        //so this finds the common interace for int and String
        // if we remove var to a data type, it won't compile
        var y2 = switch (x) {case 0 -> 0; default -> "Something";};

    }
}
