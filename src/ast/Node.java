package ast;

public interface Node extends LocationAware {

    void accept(Visitor visitor);
}
