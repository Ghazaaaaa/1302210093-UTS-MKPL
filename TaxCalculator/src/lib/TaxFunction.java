public class TaxFunction {

    public static int calculateTax(Employee employee) {
        TaxInfo taxInfo = new TaxInfo(employee.getMonthlySalary(), employee.getOtherMonthlyIncome(),
                employee.getMonthWorkingInYear(), employee.getAnnualDeductible(), employee.isMarried(), employee.getNumChildren());
        
        validateInput(taxInfo.getMonthWorkingInYear(), taxInfo.getNumChildren());
        int taxableIncome = calculateTaxableIncome(taxInfo);
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

    private static int calculateTaxableIncome(TaxInfo taxInfo) {
        int taxExemption = calculateTaxExemption(taxInfo);
        return ((taxInfo.getMonthlySalary() + taxInfo.getOtherMonthlyIncome()) * taxInfo.getMonthWorkingInYear()) - taxInfo.getAnnualDeductible() - taxExemption;
    }

    private static int calculateTaxExemption(TaxInfo taxInfo) {
        int taxExemption = 54000000;
        if (taxInfo.isMarried()) {
            taxExemption += 4500000;
        }
        taxExemption += taxInfo.getNumChildren() * 1500000;
        return taxExemption;
    }
}
