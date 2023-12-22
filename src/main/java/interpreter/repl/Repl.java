package interpreter.repl;

import java.util.Scanner;

import interpreter.lexer.Lexer;
import interpreter.token.Token;
import interpreter.token.TokenTypes;

public class Repl {
  private static final String PROMPT = "> ";

  public static void start() {
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print(PROMPT);
      String nextLine = scanner.nextLine();
      if (nextLine.contentEquals("exit")) {
        return;
      }

      Lexer l = new Lexer(nextLine);

      for (Token tok = l.nextToken(); tok.getTokenType() != TokenTypes.EOF; tok = l.nextToken()) {
        System.out.printf("{Type:%s Literal:%s}\n", tok.getTokenType(), tok.getLiteral());
      }
    }
  }
}