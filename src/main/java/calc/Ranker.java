package calc;

public class Ranker implements ExpressionVisitor<Integer>{

    @Override
    public Integer visitAddition(Addition addition) {
        return Integer.valueOf(2);
    }

    @Override
    public Integer visitSubtraction(Subtraction subtraction) {
        return Integer.valueOf(2);
    }

    @Override
    public Integer visitMultiplication(Multiplication multiplication) {
        return Integer.valueOf(1);
    }

    @Override
    public Integer visitDivision(Division division) {
        return Integer.valueOf(1);
    }

    @Override
    public Integer visitValue(Value value) {
        return Integer.valueOf(0);
    }

    @Override
    public Integer visitVariable(Variable variable) {
        return Integer.valueOf(0);
    }

    public static int rank(Expression e) {
        return e.accept(new Ranker());
    }
    
}
