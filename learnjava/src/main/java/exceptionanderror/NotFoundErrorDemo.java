package exceptionanderror;

public class NotFoundErrorDemo {
    public static void main(String[] args) {
        try {
            var errorGeneraticObject = new ErrorGeneringClass();
        } catch(Error e) {
            e.printStackTrace();
        }
        //var errorGeneraticObject2 = new ErrorGeneringClass();
        System.out.println("Done");
    }
}
