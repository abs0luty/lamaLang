package parser.visitors;

import lib.Variables;
import parser.ast.*;


public final class AssignValidator extends AbstractVisitor {

    @Override
    public void visit(AssignmentStatement s) {
        super.visit(s);
        if (Variables.isExists(s.variable)) {
            throw new RuntimeException("Cannot assign value to constant");
        }
    }
}
