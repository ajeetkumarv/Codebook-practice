package trick.varkeyword;

import java.util.ArrayList;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * https://www.youtube.com/watch?v=uEHJ5CHaF08&list=WL&index=5
 * use /v typename to see exact type for var in jshell
 */
public class VarDemo {
    public static void main(String[] args) {

        //var is not keyword, it is reserved name
        var var = 1; // is possible, like an identifier except class var {}

        //Not allowed
        //var something = null;
        //var x = 0, y = 0; //'var' is not allowed in a compound declaration

        var specificallyMentioned = (String) null;
        
        // var doesn't work anywhere in method signatures
        // like parameter, return type
        // var is not allowed at class level also, it is meant for small local usage
        // var is not allowed in catch block

        // array initi will also not work
        // var arrayData = {1, 2}
        var arrData = new Integer[]{1};

        //var lambda = () -> System.out.println("Can not be infered");

        Consumer<Integer> l1 = (var x) -> System.out.println("Can not be infered" + x);

        //but it can not mixed with expliciyt or implicit declaration like below
        //BiConsumer<Integer, String> l2 = (var x, y) -> System.out.println("");
        //BiConsumer<Integer, String> l2 = (var x, String y) -> System.out.println("");


        //this ArrayList<Object> not List<Object>
        var list = new ArrayList<>();

        // this is infered to ArrayList<Integer>
        var list2 = new ArrayList<>(Set.of(1));
    }
}
