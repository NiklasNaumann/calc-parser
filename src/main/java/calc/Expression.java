package calc;

import java.util.Map;

interface Expression {
    int evaluate(Map<String, Integer> variables);
    String toString();
    int rank();
};
