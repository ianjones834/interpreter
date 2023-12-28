package interpreter.ast;

import interpreter.ast.interfaces.Node;
import interpreter.ast.interfaces.Statement;

public class Program implements Node {
  private Statement[] statements;

  @Override
  public String TokenLiteral() {
    if (statements.length > 0) {
      return statements[0].TokenLiteral();
    }

    return "";
  }
}