package code.otherrepo.classloading;

public class Fruit {
    static  {
        System.out.println("Fruit:: first static block");
    }

    {
        System.out.println("Fruit:: instance block");
    }

    static
    {
        System.out.println("Fruit:: second static block");
    }

    public Fruit() {
        System.out.println("Fruit:: constructor");
    }


}
