package calc;

import java.util.Map;

interface Expression {
    <T> T accept(ExpressionVisitor<T> visitor);
};
