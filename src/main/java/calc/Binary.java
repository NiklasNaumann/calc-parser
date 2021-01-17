package calc;

import java.util.Map;

public abstract class Binary implements Expression {
    private final Expression lhs;
    private final Expression rhs;

    protected abstract int compute(int a, int b);
    protected abstract String symbol();

    public Binary(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public int evaluate(Map<String, Integer> variables) {
        return compute(lhs.evaluate(variables), rhs.evaluate(variables));
    }

    private String brackets(Expression e, boolean strict) {
        String s = e.toString();
        int outerRank = rank();
        int innerRank = e.rank();
        if (innerRank > outerRank || strict && innerRank == outerRank) {
            s = "(" + s + ")";
        }
        return s;
    }

    @Override
    public String toString() {
        return brackets(lhs, false) + " " + symbol() + " " + brackets(rhs, !(this instanceof Associative));
    }
}
