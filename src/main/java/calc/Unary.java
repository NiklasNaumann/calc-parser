package calc;

public abstract class Unary implements Expression {
    @Override
    public int rank() {
        return 0;
    }
}
