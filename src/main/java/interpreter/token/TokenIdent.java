package interpreter.token;

import java.util.HashMap;
import java.util.Map;

public class TokenIdent {
  static HashMap<String, TokenTypes> keywords = new HashMap<>(
    Map.of(
      "fn", TokenTypes.FUNCTION,
      "let", TokenTypes.LET)
  );

  public static TokenTypes lookupIdent(String ident) {
    if (keywords.containsKey(ident)) {
      return keywords.get(ident);
    }

    return TokenTypes.IDENT;
  }
}