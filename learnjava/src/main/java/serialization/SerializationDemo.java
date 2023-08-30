package serialization;

import java.io.*;

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
