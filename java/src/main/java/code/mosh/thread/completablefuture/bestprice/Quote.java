package code.mosh.thread.completablefuture.bestprice;

public class Quote {

    private int price;
    private String name;

    public Quote(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }
}
