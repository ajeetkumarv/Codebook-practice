package code.serialization;

public class Fruit {

    private String name;

    public Fruit(String name) {
        System.out.println("Constructor Fruit");
        this.name = name;
    }

    public Fruit() {
        this.name = "SomeFruit";
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }
}
