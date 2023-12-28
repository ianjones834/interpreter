package interpreter.parser;

import interpreter.ast.*;
import interpreter.lexer.*;
import interpreter.token.*;

public class Parser {
  private Lexer lexer;
  private Token curToken;
  private Token peekToken;

  public Parser(Lexer l) {
    lexer = l;
    nextToken();
    nextToken();
  }

  private void nextToken() {
    curToken = peekToken;
    peekToken = lexer.nextToken();
  }

  public Program ParserProgram() {
    return null;
  }
}