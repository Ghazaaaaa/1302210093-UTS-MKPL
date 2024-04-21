import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private int yearJoined;
    private int monthJoined;
    private int dayJoined;
    private int monthWorkingInYear;

    private boolean isForeigner;
    private boolean gender;

    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private String spouseName;
    private String spouseIdNumber;

    private List<String> childNames;
    private List<String> childIdNumbers;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, boolean isForeigner, boolean gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.yearJoined = yearJoined;
        this.monthJoined = monthJoined;
        this.dayJoined = dayJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;

        childNames = new LinkedList<>();
        childIdNumbers = new LinkedList<>();
    }

    public void setMonthlySalary(int grade) {
        switch (grade) {
            case 1:
                monthlySalary = isForeigner ? 4500000 : 3000000;
                break;
            case 2:
                monthlySalary = isForeigner ? 7500000 : 5000000;
                break;
            case 3:
                monthlySalary = isForeigner ? 10500000 : 7000000;
                break;
            default:
                throw new IllegalArgumentException("Invalid grade: " + grade);
        }
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = idNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childNames.add(childName);
        childIdNumbers.add(childIdNumber);
    }

    public int calculateAnnualIncomeTax() {
        LocalDate date = LocalDate.now();
        if (date.getYear() == yearJoined) {
            monthWorkingInYear = date.getMonthValue() - monthJoined;
        } else {
            monthWorkingInYear = 12;
        }
        return calculateTax();
    }

    private int calculateTax() {
        // Lakukan perhitungan pajak di sini
        // Gunakan monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber, childIdNumbers
        return 0;
    }
}
