package parser;


public enum TokenType {

    NUMBER,
    HEX_NUMBER,
    WORD,
    TEXT,
    
    // keyword
    PRINT,
    IF,
    ELSE,
    WHILE,
    FOR,
    DO,
    BREAK,
    CONTINUE,
    FN,
    RETURN,
    IMPORT,
    
    PLUS, // +
    MINUS, // -
    STAR, // *
    SLASH, // /
    PERCENT,// %
    EQ, // =
    EQEQ, // ==
    EXCL, // !
    EXCLEQ, // !=
    LTEQ, // <=
    LT, // <
    GT, // >
    GTEQ, // >=
    
    LTLT, // <<
    GTGT, // >>
    GTGTGT, // >>>
    
    TILDE, // ~
    CARET, // ^
    BAR, // |
    BARBAR, // ||
    AMP, // &
    AMPAMP, // &&
    
    QUESTION, // ?
    COLON, // :
    
    LPAREN, // (
    RPAREN, // )
    LBRACKET, // [
    RBRACKET, // ]
    LBRACE, // {
    RBRACE, // }
    COMMA, // ,
    
    EOF
}
