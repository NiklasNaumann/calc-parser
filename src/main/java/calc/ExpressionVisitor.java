package calc;

public interface ExpressionVisitor<T> {
    T visitAddition(Addition addition);
    T visitSubtraction(Subtraction subtraction);
    T visitMultiplication(Multiplication multiplication);
    T visitDivision(Division division);
    T visitValue(Value value);
    T visitVariable(Variable variable);
}
