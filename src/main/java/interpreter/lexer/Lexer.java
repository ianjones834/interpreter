package interpreter.lexer;

import interpreter.token.Token;
import interpreter.token.TokenTypes;

public class Lexer {
  String input;
  int position;
  int readPosition;
  char ch;

  public Lexer(String input) {
    this.input = input;
    this.position = 0;
    this.readPosition = 0;
    this.readChar();
  }

  private void readChar() {
    if (this.readPosition >= this.input.length()) {
      this.ch = 0;
    }
    else {
      this.ch = this.input.charAt(this.readPosition);
    }

    this.position = this.readPosition;
    this.readPosition++;
  }

  public Token nextToken() {
    Token tok;

    switch (this.ch) {
      case '=' -> tok = new Token(TokenTypes.ASSIGN, String.valueOf(this.ch));
      case ';' -> tok = new Token(TokenTypes.SEMICOLON, String.valueOf(this.ch));
      case '(' -> tok = new Token(TokenTypes.LPAREN, String.valueOf(this.ch));
      case ')' -> tok = new Token(TokenTypes.RPAREN, String.valueOf(this.ch));
      case ',' -> tok = new Token(TokenTypes.COMMA, String.valueOf(this.ch));
      case '+' -> tok = new Token(TokenTypes.PLUS, String.valueOf(this.ch));
      case '{' -> tok = new Token(TokenTypes.LBRACE, String.valueOf(this.ch));
      case '}' -> tok = new Token(TokenTypes.RBRACE, String.valueOf(this.ch));
      case 0 -> tok = new Token(TokenTypes.EOF, "");
      default -> tok = new Token(TokenTypes.ILLEGAL, "");
    }

    this.readChar();
    return tok;
  }
}