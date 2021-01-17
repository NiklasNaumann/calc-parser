package calc;

import java.util.Map;

public abstract class Binary implements Expression {
    private final Expression lhs;
    private final Expression rhs;

    public Binary(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
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
}
