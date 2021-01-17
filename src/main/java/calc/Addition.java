package calc;

public class Addition extends Binary implements Associative {

    public Addition(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    protected int compute(int a, int b) {
        return a + b;
    }

    @Override
    protected String symbol() {
        return "+";
    }

    @Override
    public int rank() {
        return 2;
    }
}
