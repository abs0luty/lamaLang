package ast;

import lib.modules.Module;

public final class UseStatement implements Statement {

    private static final String PACKAGE = "lib.modules.";

    public final Expression expression;

    public UseStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        try {
            final String moduleName = expression.eval().asString();
            final Module module = (Module) Class.forName(PACKAGE + moduleName).newInstance();
            module.init();
        } catch (Exception ex) {
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "use " + expression;
    }
}
