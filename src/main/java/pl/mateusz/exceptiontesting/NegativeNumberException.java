package pl.mateusz.exceptiontesting;

public class NegativeNumberException extends RuntimeException {

  public NegativeNumberException(int number) {
    super("You cannot calculate square from number %d".formatted(number));
  }

  public NegativeNumberException(String message) {
        super(message);
    }
}
