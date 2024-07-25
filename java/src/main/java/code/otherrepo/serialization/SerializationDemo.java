package code.otherrepo.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Fruit f = new Apple("apple");

        //ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("fruits.ser"));
        //oo.writeObject(f);


        ObjectInput oo = new ObjectInputStream(new FileInputStream("fruits.ser"));
        Fruit f2 = (Fruit)oo.readObject();

        System.out.println(f2);
    }
}
