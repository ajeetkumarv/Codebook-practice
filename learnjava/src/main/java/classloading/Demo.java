package classloading;

public class Demo {
    public static void main(String[] args) {
        Apple apple = new Apple();
        /*
            OUTPUT
            Fruit:: static block
            Fruit:: second static block
            Apple:: static block
            Fruit:: instance block
            Apple:: instance block
            Apple::Constructor

            will be same for Fruit f = new Apple();
        */
    }
}
