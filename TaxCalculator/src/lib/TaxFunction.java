public class TaxFunction {

    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        validateInput(numberOfMonthWorking, numberOfChildren);
        int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking, deductible, isMarried, numberOfChildren);
        return Math.max(0, Math.round(0.05 * taxableIncome));
    }

    private static void validateInput(int numberOfMonthWorking, int numberOfChildren) {
        if (numberOfMonthWorking > 12) {
            throw new IllegalArgumentException("More than 12 month working per year");
        }
        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }
    }

    private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
        int taxExemption = calculateTaxExemption(isMarried, numberOfChildren);
        return ((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - taxExemption;
    }

    private static int calculateTaxExemption(boolean isMarried, int numberOfChildren) {
        int taxExemption = 54000000;
        if (isMarried) {
            taxExemption += 4500000;
        }
        taxExemption += numberOfChildren * 1500000;
        return taxExemption;
    }
}
