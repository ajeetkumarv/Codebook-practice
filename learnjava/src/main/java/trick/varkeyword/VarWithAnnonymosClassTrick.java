package trick.varkeyword;

public class VarWithAnnonymosClassTrick {
    public static void main(String[] args) {
        var obj = new Object() { int x = 0; String y="Zero";};
        System.out.println(obj.x);
        //Thing to notice here is how Annonymous class obj is aware of x
        //we may think it must be Object and should be aware of x an y
        //but it not object it is some(Annonymous) Child class of Object

        //below is not gonna work like above
        Object obj2 = new Object() { int x = 0; String y="Zero";};
    }
}
