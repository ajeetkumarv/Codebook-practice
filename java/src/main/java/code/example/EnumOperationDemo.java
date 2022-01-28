package code.example;

import java.math.BigDecimal;
import java.util.function.BiFunction;

enum Operation {
    PLUS("+", (x, y) -> x.add(y)),
    SUBTRACT("-", (x, y) -> x.min(y));


    private String symbol;
    private BiFunction<BigDecimal, BigDecimal, BigDecimal> function;

    Operation(String symbol, BiFunction<BigDecimal, BigDecimal, BigDecimal> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public BigDecimal apply(BigDecimal first, BigDecimal second) {
        return function.apply(first, second);
    }
}

public class EnumOperationDemo {
    public static void main(String[] args) {
        Operation.PLUS.apply(BigDecimal.TEN, BigDecimal.ONE);
    }
}
