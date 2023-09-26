package ast;

public final class BreakStatement extends RuntimeException implements Statement {

    private final SegmentLocation location;

    public BreakStatement(SegmentLocation location) {
        this.location = location;
    }

    @Override
    public SegmentLocation getLocation() {
        return location;
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
        return "break";
    }
}
