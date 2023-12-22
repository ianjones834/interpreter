package interpreter;

import interpreter.lexer.Lexer;
import interpreter.token.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LexerTest {

  @Test
  @DisplayName("Token Type of '=+(){},;'")
  void tokenTypeEquals() {
    String input = """
    let five = 5;
    let ten = 10;

    let add = fn(x,y) {
      x + y;
    };

    let result = add(five, ten);

    !-/*5;
    5 < 10 > 5;

    if (5 < 10) {
      return true;
    } else {
      return false;
    }

    10 == 10;
    10 != 9;
  """;

    Token[] expectedTokens = {
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "five"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "ten"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "add"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.FUNCTION, "fn"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.IDENT, "x"),
      new Token(TokenTypes.COMMA, ","),
      new Token(TokenTypes.IDENT, "y"),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.LBRACE, "{"),
      new Token(TokenTypes.IDENT, "x"),
      new Token(TokenTypes.PLUS, "+"),
      new Token(TokenTypes.IDENT, "y"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.RBRACE, "}"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "result"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.IDENT, "add"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.IDENT, "five"),
      new Token(TokenTypes.COMMA, ","),
      new Token(TokenTypes.IDENT, "ten"),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.BANG, "!"),
      new Token(TokenTypes.MINUS, "-"),
      new Token(TokenTypes.SLASH, "/"),
      new Token(TokenTypes.ASTERISK, "*"),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.LT, "<"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.GT, ">"),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.IF, "if"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.LT, "<"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.LBRACE, "{"),
      new Token(TokenTypes.RETURN, "return"),
      new Token(TokenTypes.TRUE, "true"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.RBRACE, "}"),
      new Token(TokenTypes.ELSE, "else"),
      new Token(TokenTypes.LBRACE, "{"),
      new Token(TokenTypes.RETURN, "return"),
      new Token(TokenTypes.FALSE, "false"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.RBRACE, "}"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.EQ, "=="),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.NOT_EQ, "!="),
      new Token(TokenTypes.INT, "9"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.EOF, ""),
    };

    Lexer l = new Lexer(input);

    ArrayList<Token> tokens = new ArrayList<>();
    tokens.add(l.nextToken());

    while (tokens.getLast().getTokenType() != TokenTypes.EOF) {
      tokens.add(l.nextToken());
    }

    for (int i = 0; i < tokens.size(); i++) {
      assertEquals(expectedTokens[i].getTokenType(), tokens.get(i).getTokenType());
    }
  }

  @Test
  @DisplayName("Token Literals of '=+(){},;'")
  void tokenLiteralsEquals() {
    String input = """
    let five = 5;
    let ten = 10;

    let add = fn(x,y) {
      x + y;
    };

    let result = add(five, ten);

    !-/*5;
    5 < 10 > 5;

    if (5 < 10) {
      return true;
    } else {
      return false;
    }

    10 == 10;
    10 != 9;
  """;

    Token[] expectedTokens = {
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "five"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "ten"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "add"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.FUNCTION, "fn"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.IDENT, "x"),
      new Token(TokenTypes.COMMA, ","),
      new Token(TokenTypes.IDENT, "y"),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.LBRACE, "{"),
      new Token(TokenTypes.IDENT, "x"),
      new Token(TokenTypes.PLUS, "+"),
      new Token(TokenTypes.IDENT, "y"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.RBRACE, "}"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.LET, "let"),
      new Token(TokenTypes.IDENT, "result"),
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.IDENT, "add"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.IDENT, "five"),
      new Token(TokenTypes.COMMA, ","),
      new Token(TokenTypes.IDENT, "ten"),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.BANG, "!"),
      new Token(TokenTypes.MINUS, "-"),
      new Token(TokenTypes.SLASH, "/"),
      new Token(TokenTypes.ASTERISK, "*"),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.LT, "<"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.GT, ">"),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.IF, "if"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.INT, "5"),
      new Token(TokenTypes.LT, "<"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.LBRACE, "{"),
      new Token(TokenTypes.RETURN, "return"),
      new Token(TokenTypes.TRUE, "true"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.RBRACE, "}"),
      new Token(TokenTypes.ELSE, "else"),
      new Token(TokenTypes.LBRACE, "{"),
      new Token(TokenTypes.RETURN, "return"),
      new Token(TokenTypes.FALSE, "false"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.RBRACE, "}"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.EQ, "=="),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.INT, "10"),
      new Token(TokenTypes.NOT_EQ, "!="),
      new Token(TokenTypes.INT, "9"),
      new Token(TokenTypes.SEMICOLON, ";"),
      new Token(TokenTypes.EOF, ""),
    };

    Lexer l = new Lexer(input);

    ArrayList<Token> tokens = new ArrayList<>();
    tokens.add(l.nextToken());

    while (tokens.getLast().getTokenType() != TokenTypes.EOF) {
      tokens.add(l.nextToken());
    }

    for (int i = 0; i < tokens.size(); i++) {
      assertEquals(expectedTokens[i].getTokenType(), tokens.get(i).getTokenType());
    }
  }
}
