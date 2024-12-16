package pl.mateusz.pyramidtesting;

public class DoseCalculator {
    // Method for calculating the corrected dose of medicine based on the corrected formula
    public double calculateYoungDose(double adultDose, double childAgeInYears) {

        if (adultDose == 0 || childAgeInYears == 0) {
            throw new IllegalArgumentException("Values cannot be zero");
        } else if (childAgeInYears > 14) {
            throw new IllegalArgumentException("child age cannot be grater than 14 years");
        }

        return adultDose * (childAgeInYears / (childAgeInYears + 12));
    }
}
