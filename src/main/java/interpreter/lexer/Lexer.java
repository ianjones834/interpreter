package interpreter.lexer;

import interpreter.token.*;

public class Lexer {
  String input;
  int position;
  int readPosition;
  char ch;

  public Lexer(String input) {
    this.input = input;
    position = 0;
    readPosition = 0;
    readChar();
  }

  private void readChar() {
    if (readPosition >= input.length()) {
      ch = 0;
    }
    else {
      ch = input.charAt(readPosition);
    }

    position = readPosition;
    readPosition++;
  }

  private boolean isLetter() {
    return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
  }

  private boolean isDigit() {
    return ch >= '0' && ch <= '9';
  }

  private String readIdentifier() {
    int start = position;

    while (isLetter()) {
      readChar();
    }

    return input.substring(start, position);
  }

  private String readNumber() {
    int start = position;

    while (isDigit()) {
      readChar();
    }

    return input.substring(start, position);
  }

  private void skipWhitespace() {
    while (ch == ' ' || ch == '\n' || ch == '\t' || ch == '\r') {
      readChar();
    }

    return;
  }

  private char peekChar() {
    if (readPosition >= input.length()) {
      return 0;
    }
    else {
      return input.charAt(readPosition);
    }
  }

  public Token nextToken() {
    Token tok = null;

    skipWhitespace();

    switch (ch) {
      case '=' -> {
        if (peekChar() == '=') {
          char tmp = ch;
          readChar();
          char[] literal = {tmp, ch};
          tok = new Token(TokenTypes.EQ, new String(literal));
        }
        else {
          tok = new Token(TokenTypes.ASSIGN, String.valueOf(ch));
        }
      }
      case '+' -> tok = new Token(TokenTypes.PLUS, String.valueOf(ch));
      case '-' -> tok = new Token(TokenTypes.MINUS, String.valueOf(ch));
      case '!' -> {
        if (peekChar() == '=') {
          char tmp = ch;
          readChar();
          char[] literal = {tmp, ch};
          tok = new Token(TokenTypes.NOT_EQ, new String(literal));
        }
        else {
          tok = new Token(TokenTypes.BANG, String.valueOf(ch));
        }
      }
      case '/' -> tok = new Token(TokenTypes.SLASH, String.valueOf(ch));
      case '*' -> tok = new Token(TokenTypes.ASTERISK, String.valueOf(ch));
      case '<' -> tok = new Token(TokenTypes.LT, String.valueOf(ch));
      case '>' -> tok = new Token(TokenTypes.GT, String.valueOf(ch));

      case ';' -> tok = new Token(TokenTypes.SEMICOLON, String.valueOf(ch));
      case ',' -> tok = new Token(TokenTypes.COMMA, String.valueOf(ch));

      case '(' -> tok = new Token(TokenTypes.LPAREN, String.valueOf(ch));
      case ')' -> tok = new Token(TokenTypes.RPAREN, String.valueOf(ch));
      case '{' -> tok = new Token(TokenTypes.LBRACE, String.valueOf(ch));
      case '}' -> tok = new Token(TokenTypes.RBRACE, String.valueOf(ch));

      case 0 -> tok = new Token(TokenTypes.EOF, "");
      default -> {
        if (isLetter()) {
          tok = new Token(null, readIdentifier());
          tok.setTokenType(TokenIdent.lookupIdent(tok.getLiteral()));

          return tok;
        }
        else if (isDigit()) {
          tok = new Token(TokenTypes.INT, null);
          tok.setLiteral(readNumber());
          return tok;
        }
        else {
          tok = new Token(TokenTypes.ILLEGAL, String.valueOf(ch));
        }
      }
    }

    readChar();
    return tok;
  }
}