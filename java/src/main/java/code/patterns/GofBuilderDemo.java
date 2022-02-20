package code.patterns;


/**
 * http://www.blackwasp.co.uk/Builder_2.aspx
 */

class Meal {
    String item;
    String sideItem;
    String drink;
    int offer;
    int price;

    @Override
    public String toString() {
        return "Meal{" +
                "item='" + item + '\'' +
                ", sideItem='" + sideItem + '\'' +
                ", drink='" + drink + '\'' +
                ", offer=" + offer +
                ", price=" + price +
                '}';
    }
}

abstract class MealBuilder {
    abstract void createItem();
    abstract void createSideItem();
    abstract void createDrink();
    abstract void applyOffer();
    abstract void getPrice();

    abstract Meal getMeal();
}

class VegMealBuilder extends MealBuilder {
    private Meal meal = new Meal();

    void createItem() {
        meal.item = "Veg item";
    }

    void createSideItem() {
        meal.sideItem = "Veg side item";
    }

    @Override
    void createDrink() {
    }

    @Override
    void applyOffer() {
    }

    void getPrice() {
        meal.price = 100;
    }

    @Override
    Meal getMeal() {
        return meal;
    }
}

class MealDirector {
    public void createMeal(MealBuilder builder) {
        builder.createItem();
        builder.createSideItem();
        builder.createDrink();
        builder.applyOffer();
        builder.getPrice();
    }
}

public class GofBuilderDemo {

    public static void main(String[] args) {
        MealDirector director = new MealDirector();

        MealBuilder mealBuilder = new VegMealBuilder();

        director.createMeal(mealBuilder);

        Meal meal = mealBuilder.getMeal();

        System.out.println("Meal: " + meal);
    }

}
