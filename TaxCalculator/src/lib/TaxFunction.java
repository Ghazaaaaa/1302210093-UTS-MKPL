public class TaxFunction {

    public static int calculateTax(Employee employee) {
        validateInput(employee.getMonthWorkingInYear(), employee.getNumChildren());
        int taxableIncome = calculateTaxableIncome(employee);
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

    private static int calculateTaxableIncome(Employee employee) {
        int taxExemption = calculateTaxExemption(employee);
        return ((employee.getMonthlySalary() + employee.getOtherMonthlyIncome()) * employee.getMonthWorkingInYear()) - employee.getAnnualDeductible() - taxExemption;
    }

    private static int calculateTaxExemption(Employee employee) {
        int taxExemption = 54000000;
        if (employee.isMarried()) {
            taxExemption += 4500000;
        }
        taxExemption += employee.getNumChildren() * 1500000;
        return taxExemption;
    }
}
