package code.classloading;

public class Fruit {
    static  {
        System.out.println("Fruit:: static block");
    }

    {
        System.out.println("Fruit:: instance block");
    }

    public Fruit() {
        System.out.println("Fruit:: constructor");
    }

    static
    {
        System.out.println("Fruit:: second static block");
    }

}
