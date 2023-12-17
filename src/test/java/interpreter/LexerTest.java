package interpreter;

import interpreter.lexer.Lexer;
import interpreter.token.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class LexerTest {


  @Test
  @DisplayName("Token Type of '=+(){},;'")
  void tokenTypeEquals() {
    String input = "=+(){},;";
    Token[] expectedTokens = {
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.PLUS, "+"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.LBRACE, "["),
      new Token(TokenTypes.RBRACE, "]"),
      new Token(TokenTypes.COMMA, ","),
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
    String input = "=+(){},;";
    Token[] expectedTokens = {
      new Token(TokenTypes.ASSIGN, "="),
      new Token(TokenTypes.PLUS, "+"),
      new Token(TokenTypes.LPAREN, "("),
      new Token(TokenTypes.RPAREN, ")"),
      new Token(TokenTypes.LBRACE, "{"),
      new Token(TokenTypes.RBRACE, "}"),
      new Token(TokenTypes.COMMA, ","),
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
