package ast;

public final class IfStatement implements Statement {

    public final Expression condition;
    public final Statement ifStatement, elseStatement;

    public IfStatement(Expression expression, Statement ifStatement, Statement elseStatement) {
        this.condition = expression;
        this.ifStatement = ifStatement;
        this.elseStatement = elseStatement;
    }

    @Override
    public SegmentLocation getLocation() {
        return new SegmentLocation(
                condition.getLocation().getFirstByteLocation(),
                elseStatement.getLocation().getLastByteLocation());
    }

    @Override
    public void execute() {
        final double result = condition.eval().asNumber();
        if (result != 0) {
            ifStatement.execute();
        } else if (elseStatement != null) {
            elseStatement.execute();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append("if ").append(condition).append(' ').append(ifStatement);
        if (elseStatement != null) {
            result.append("\nelse ").append(elseStatement);
        }
        return result.toString();
    }
}
