package ast;

import lib.Value;
import lib.Variables;

public final class VariableExpression implements Expression {

    private final String name;
    private final SegmentLocation location;

    public VariableExpression(String name, SegmentLocation location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    @Override
    public Value eval() {
        if (!Variables.isExists(name))
            throw new RuntimeException("Variable does not exists: " + name);
        return Variables.get(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public SegmentLocation getLocation() {
        return location;
    }
}
