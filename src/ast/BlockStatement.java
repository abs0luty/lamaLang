package ast;

import java.util.ArrayList;
import java.util.List;

public final class BlockStatement implements Statement {

    private final SegmentLocation location;
    private final List<Statement> statements;

    public BlockStatement(SegmentLocation location, List<Statement> statements) {
        this.location = location;
        this.statements = statements;
    }

    public BlockStatement(SegmentLocation location) {
        this.location = location;
        statements = new ArrayList<>();
    }

    @Override
    public SegmentLocation getLocation() {
        return location;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void addStatement(Statement statement) {
        statements.add(statement);
    }

    @Override
    public void execute() {
        for (Statement statement : statements) {
            statement.execute();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        for (Statement statement : statements) {
            result.append(statement.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
