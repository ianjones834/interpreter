package interpreter.ast;

import interpreter.ast.interfaces.Expression;
import interpreter.token.Token;

public class Identifier implements Expression {
  private Token token;
  private String value;

  @Override
  public String TokenLiteral() {
    return token.getLiteral();
  }

  @Override
  public void expressionNode() {

  }
}