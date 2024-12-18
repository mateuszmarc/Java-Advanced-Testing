package pl.mateusz.enums;

public class PrimeNumberChecker {

    public static boolean isPrime(int number) {

        if (number <= 1) {
            return false;
        }

        boolean isPrimeNumber = true;

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return isPrimeNumber;
    }
}
