package ast;

import lib.Value;

public interface Expression extends Node {

    Value eval();
}
