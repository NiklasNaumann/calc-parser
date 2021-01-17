package calc;

import java.util.Map;

public class Variable extends Unary {

    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int evaluate(Map<String, Integer> variables) {
        if (!variables.containsKey(name)) {
            throw new CalcException("Unknown variable: " + name);
        }
        return variables.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
