package code.generics;

class SimpleData<T> {
    T value;

    SimpleData(T t) {
        this.value = t;
    }

    @Override
    public boolean equals(Object other) {

        if (other instanceof SimpleData<?>) { // SimpleData<T> is compile-time error
            if( ((SimpleData<T>)other).value.equals(value)) {
                return true;
            }
        }
        return false;
    }
}

public class EqualsForGenerics {

    public static void main(String[] args) {

        SimpleData<Integer> intData = new SimpleData<>(5);
        SimpleData<Integer> intData2 = new SimpleData<>(5);

        SimpleData<String> intData3 = new SimpleData<>("Five");

        System.out.println(intData.equals(intData2));
        System.out.println(intData.equals(intData3));

    }

}
