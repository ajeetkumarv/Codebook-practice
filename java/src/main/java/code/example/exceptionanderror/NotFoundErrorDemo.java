package code.example.exceptionanderror;

public class NotFoundErrorDemo {
    public static void main(String[] args) {
        try {
            var errorGeneraticObject = new ErrorGeneringClass();
        } catch(Throwable e) {
            e.printStackTrace();
        }

        // Since class init failed bcz of static method exception
        // this class is not loaded hence NoClassDefFoundError
        var errorGeneraticObject2 = new ErrorGeneringClass();

    }
}
