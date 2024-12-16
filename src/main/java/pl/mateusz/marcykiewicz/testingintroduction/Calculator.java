package pl.mateusz.marcykiewicz.testingintroduction;

public class Calculator {

    public int add(int a, int b) {
        if ((a > 0 && b == Integer.MAX_VALUE)
                || (a == Integer.MAX_VALUE && b > 0)
                || (a == Integer.MIN_VALUE && b < 0)
                || (a < 0 && b == Integer.MIN_VALUE)
        ) {
            throw new ArithmeticException("You cannot use such combination of parameters");
        }
        return a + b;
    }
}
