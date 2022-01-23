package code.classloading;

public class Fruit {
    static  {
        System.out.println("Fruit:: static block");
    }

    {
        System.out.println("Fruit:: instance block");
    }

    static
    {
        System.out.println("Fruit:: second static block");
    }

}
