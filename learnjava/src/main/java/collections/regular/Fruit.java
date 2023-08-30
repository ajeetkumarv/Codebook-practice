package collections.regular;

public class Fruit { //implements Comparable<Fruit>{
    private int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }

    //@Override
    public int compareTo(Fruit o) {
        return 0;
    }
}