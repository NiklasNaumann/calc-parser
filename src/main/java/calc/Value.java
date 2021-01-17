package calc;

import java.util.Map;

public class Value implements Expression {
    private final int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        // TODO Auto-generated method stub
        return null;
    }
}
