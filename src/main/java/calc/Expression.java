package calc;

interface Expression {
    <T> T accept(ExpressionVisitor<T> visitor);
};
