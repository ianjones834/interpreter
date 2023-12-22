package interpreter;

import interpreter.repl.Repl;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello, welcome to the Monkey programming language!");
    System.out.println("Type some commands ('exit' to exit the program)");
    Repl.start();
  }
}