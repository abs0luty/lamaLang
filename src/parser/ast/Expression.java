package parser.ast;

import lib.Value;


public interface Expression extends Node {
    
    Value eval();
}
