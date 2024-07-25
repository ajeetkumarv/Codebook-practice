package code.otherrepo.classloading;

public class Apple extends Fruit {
    static  {
        System.out.println("Apple:: static block");
    }

    {
        System.out.println("Apple:: instance block");
    }

    public Apple() {
        System.out.println("Apple::Constructor");
    }
}
