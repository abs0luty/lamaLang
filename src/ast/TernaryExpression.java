package ast;

import lib.Value;

public final class TernaryExpression implements Expression {

    public final Expression condition;
    public final Expression truePart, falsePart;

    public TernaryExpression(Expression condition, Expression truePart, Expression falsePart) {
        this.condition = condition;
        this.truePart = truePart;
        this.falsePart = falsePart;
    }

    @Override
    public Value eval() {
        if (condition.eval().asNumber() != 0) {
            return truePart.eval();
        } else {
            return falsePart.eval();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("%s ? %s : %s", condition, trueExpr, falseExpr);
    }
}
