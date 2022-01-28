package code.example.serialization;

import java.io.Serializable;

public class Apple extends Fruit implements Serializable {
    public Apple(String name) {
        super(name);
    }
}
