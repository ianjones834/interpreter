package interpreter.token;

public class Token {
  TokenTypes tokenType;
  String literal;

  public Token(TokenTypes tokenType, String literal) {
    this.tokenType = tokenType;
    this.literal = literal;
  }

  public TokenTypes getTokenType() {
    return tokenType;
  }

  public String getLiteral() {
    return literal;
  }

  public void setTokenType(TokenTypes tokenType) {
    this.tokenType = tokenType;
  }

  public void setLiteral(String literal) {
    this.literal = literal;
  }
}