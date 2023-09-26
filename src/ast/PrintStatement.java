package ast;

public final class PrintStatement implements Statement {

    private final SegmentLocation location;
    private final Expression expression;

    public PrintStatement(SegmentLocation location, Expression expression) {
        this.location = location;
        this.expression = expression;
    }

    @Override
    public SegmentLocation getLocation() {
        return location;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void execute() {
        System.out.print(expression.eval());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "print " + expression;
    }
}
