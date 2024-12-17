package pl.mateusz.parametrizedtests;

public enum SquareScenario {
    POSITIVE_NUMBER(8, 64),
    NEGATIVE_NUMBER(-4, 16),
    ZERO(0, 0);

    final int input;
    final int expectedOutput;


    SquareScenario(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    public int getInput() {
        return input;
    }

    public int getExpectedOutput() {
        return expectedOutput;
    }
}
