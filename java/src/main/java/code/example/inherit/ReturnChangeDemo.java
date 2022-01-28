package code.example.inherit;

import java.io.IOException;

class Fruit {
    public String taste() throws Exception {
        return "Tastey";
    }
}

class Apple extends Fruit {
    public String taste() { // only child exception of super class throws will work or no excepion
        return "Nice";
    }
}

public class ReturnChangeDemo {
}
