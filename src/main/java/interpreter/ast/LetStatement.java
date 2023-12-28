package interpreter.ast;

import interpreter.ast.interfaces.Expression;
import interpreter.ast.interfaces.Statement;
import interpreter.token.Token;

public class LetStatement implements Statement {
  private Token token;
  private Identifier name;
  private Expression value;

  @Override
  public String TokenLiteral() {
    return token.getLiteral();
  }

  @Override
  public void statementNode() {

  }
}