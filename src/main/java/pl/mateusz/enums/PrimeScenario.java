package pl.mateusz.enums;

public enum PrimeScenario {
    NUMBER_2(2, true),

    NUMBER_3(3, true),

    NUMBER_4(4, false),

    NUMBER_5(5, true),

    NUMBER_6(6, false),

    NUMBER_7(7, true),

    NUMBER_8(8, false),

    NUMBER_9(9, false),

    NUMBER_10(10, false),

    NUMBER_11(11, true),

    NUMBER_12(12, false);

    private int number;
    private boolean isPrimeNumber;

    PrimeScenario(int number, boolean isPrimeNumber) {
        this.number = number;
        this.isPrimeNumber = isPrimeNumber;
    }

    public int getNumber() {
        return number;
    }

    public boolean isPrimeNumber() {
        return isPrimeNumber;
    }
}
