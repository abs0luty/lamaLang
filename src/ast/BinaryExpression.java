package ast;

import lib.ArrayValue;
import lib.NumberValue;
import lib.StringValue;
import lib.Value;

public final class BinaryExpression implements Expression {

    public enum Operator {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        REMAINDER("%"),
        // Bitwise
        AND("&"),
        OR("|"),
        XOR("^"),
        LSHIFT("<<"),
        RSHIFT(">>"),
        URSHIFT(">>>");

        private final String name;

        private Operator(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private final Operator operation;
    private final Expression leftExpression, rightExpression;

    public BinaryExpression(Operator operation, Expression leftExpression, Expression rightExpression) {
        this.operation = operation;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    public Operator getOperation() {
        return operation;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public SegmentLocation getLocation() {
        return new SegmentLocation(
                leftExpression.getLocation().getFirstByteLocation(),
                rightExpression.getLocation().getLastByteLocation());
    }

    @Override
    public Value eval() {
        final Value value1 = leftExpression.eval();
        final Value value2 = rightExpression.eval();
        if ((value1 instanceof StringValue) || (value1 instanceof ArrayValue)) {
            final String string1 = value1.asString();
            switch (operation) {
                case MULTIPLY: {
                    final int iterations = (int) value2.asNumber();
                    final StringBuilder buffer = new StringBuilder();
                    for (int i = 0; i < iterations; i++) {
                        buffer.append(string1);
                    }
                    return new StringValue(buffer.toString());
                }
                case ADD:
                default:
                    return new StringValue(string1 + value2.asString());
            }
        }

        final double number1 = value1.asNumber();
        final double number2 = value2.asNumber();
        double result;
        switch (operation) {
            case ADD:
                result = number1 + number2;
                break;
            case SUBTRACT:
                result = number1 - number2;
                break;
            case MULTIPLY:
                result = number1 * number2;
                break;
            case DIVIDE:
                result = number1 / number2;
                break;
            case REMAINDER:
                result = number1 % number2;
                break;

            // Bitwise
            case AND:
                result = (int) number1 & (int) number2;
                break;
            case XOR:
                result = (int) number1 ^ (int) number2;
                break;
            case OR:
                result = (int) number1 | (int) number2;
                break;
            case LSHIFT:
                result = (int) number1 << (int) number2;
                break;
            case RSHIFT:
                result = (int) number1 >> (int) number2;
                break;
            case URSHIFT:
                result = (int) number1 >>> (int) number2;
                break;

            default:
                throw new RuntimeException("Operation " + operation + " is not supported");
        }
        return new NumberValue(result);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", leftExpression, operation, rightExpression);
    }
}
