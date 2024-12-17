package pl.mateusz.parametrizedtests;

public class Numbers {
    public static String checkParity(int number) {
        if (number == 0) return "zero";
        return number % 2 == 0 ? "even" : "odd";
    }
}
