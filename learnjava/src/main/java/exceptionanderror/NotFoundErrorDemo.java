package exceptionanderror;

public class NotFoundErrorDemo {
    public static void main(String[] args) {
        try {
            var errorGeneraticObject = new ErrorGeneringClass();
        } catch(Throwable e) {
            e.printStackTrace();
        }
        var errorGeneraticObject2 = new ErrorGeneringClass();

    }
}
