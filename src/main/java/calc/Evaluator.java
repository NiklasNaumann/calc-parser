package calc;

import java.util.Map;

public class Evaluator implements ExpressionVisitor<Integer> {

    Map<String, Integer> variables;

    public Evaluator(Map<String, Integer> variables) {
        this.variables = variables;
    }

    @Override
    public Integer visitAddition(Addition addition) {
        return evaluate(addition.lhs, variables) + evaluate(addition.rhs, variables);
    }

    @Override
    public Integer visitSubtraction(Subtraction subtraction) {
        return evaluate(subtraction.lhs, variables) - evaluate(subtraction.rhs, variables);
    }

    @Override
    public Integer visitMultiplication(Multiplication multiplication) {
        return evaluate(multiplication.lhs, variables) * evaluate(multiplication.rhs, variables);
    }

    @Override
    public Integer visitDivision(Division division) {
        return evaluate(division.lhs, variables) / evaluate(division.rhs, variables);
    }

    @Override
    public Integer visitValue(Value value) {
        return value.value;
    }

    @Override
    public Integer visitVariable(Variable variable) {
        if (!variables.containsKey(variable.name)) {
            throw new CalcException("Unknown variable: " + variable.name);
        }
        return variables.get(variable.name);
    }

    public static int evaluate(Expression e, Map<String, Integer> variables) {
        return e.accept(new Evaluator(variables));
    }
    
}
