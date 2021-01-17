package calc;

import java.util.Map;

public class Value extends Unary {
    private final int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public int evaluate(Map<String, Integer> variables) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
