package ast;


import parser.TokenType;

public final class Token implements LocationAware {

    private final TokenType type;
    private final SegmentLocation location;

    public Token(TokenType type, SegmentLocation location) {
        this.type = type;
        this.location = location;
    }

    public TokenType getType() {
        return type;
    }

    @Override
    public SegmentLocation getLocation() {
        return location;
    }
}
