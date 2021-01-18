package calc;

public class Printer implements ExpressionVisitor<String>{

    @Override
    public String visitAddition(Addition addition) {
        return brackets(addition, addition.lhs, false) + " + " + brackets(addition, addition.rhs, !(this instanceof Associative));
    }

    @Override
    public String visitSubtraction(Subtraction subtraction) {
        return brackets(subtraction, subtraction.lhs, false) + " - " + brackets(subtraction, subtraction.rhs, !(this instanceof Associative));
    }

    @Override
    public String visitMultiplication(Multiplication multiplication) {
        return brackets(multiplication, multiplication.lhs, false) + " * " + brackets(multiplication, multiplication.rhs, !(this instanceof Associative));
    }

    @Override
    public String visitDivision(Division division) {
        return brackets(division, division.lhs, false) + " / " + brackets(division, division.rhs, !(this instanceof Associative));
    }

    @Override
    public String visitValue(Value value) {
        return Integer.toString(value.value);
    }

    @Override
    public String visitVariable(Variable variable) {
        return variable.name;
    }

    public static String toString(Expression e) {
        return e.accept(new Printer());
    }

    private String brackets(Expression e, Expression lrhs, boolean strict){
        String s = Printer.toString(lrhs);
        int outerRank = Ranker.rank(e);
        int innerRank = Ranker.rank(lrhs);
        if (innerRank > outerRank || strict && innerRank == outerRank) {
            s = "(" + s + ")";
        }
        return s;
    }
    
}
