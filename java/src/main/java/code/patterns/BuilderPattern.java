package code.patterns;

/**
 * https://stackoverflow.com/questions/328496/when-would-you-use-the-builder-pattern
 *
 * The builder pattern is a good choice when designing classes whose constructors
 * or static factories would have more than a handful of parameters.
 *
 * Telescoping Constructor Pattern
 *
 */
class Pizza {
    private int size; // required

    private boolean cheese, pepper, bacon; //optional

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepper = builder.pepper;
        this.bacon = builder.bacon;
    }

    static class Builder {
        private int size; // required
        private boolean cheese, pepper, bacon; //optional
        Builder(int size) {
            this.size = size;
        }

        Builder cheese(){
            cheese = true;
            return this;
        }

        Builder pepper(){
            pepper = true;
            return this;
        }

        Builder bacon(){
            bacon = true;
            return this;
        }

        Pizza build() {
            return new Pizza(this);
        }
    }

}


public class BuilderPattern {

    public static void main(String[] args) {

        Pizza pizza = new Pizza.Builder(5)
                .cheese()
                .pepper()
                .build();

    }

}
