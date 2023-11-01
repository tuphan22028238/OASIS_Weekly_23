public class Addition extends BinaryExpression {
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}
