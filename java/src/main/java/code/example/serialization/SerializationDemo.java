package code.example.serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Fruit f = new Apple("apple");
        Fruit f2 = new Apple("pineapple");

        ObjectOutput oo = new ObjectOutputStream(new FileOutputStream("fruits.ser"));
        oo.writeObject(f);
        oo.writeObject(f2);

        ObjectInput oi = new ObjectInputStream(new FileInputStream("fruits.ser"));
        Fruit fRead = (Fruit)oi.readObject();
        Fruit f2Read = (Fruit)oi.readObject();

        System.out.println(fRead);
        System.out.println(f2Read);
    }
}
