package ast;

import lib.Value;

public final class ReturnStatement extends RuntimeException implements Statement {

    private final Expression expression;
    private final SegmentLocation location;

    public ReturnStatement(Expression expression, SegmentLocation location) {
        this.expression = expression;
        this.location = location;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void execute() {
        throw this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "return " + expression;
    }

    @Override
    public SegmentLocation getLocation() {
        return location;
    }
}
