package personeksempel;

public class Person {
    //Fields
    private String name;
    private String address;
    private double monthlySalary;
    private int workplaceNumber;
    private String currentEmployment;

    //Constructor
    public Person (String name, String address, double monthlySalary) {
        this.name = name;
        this.address = address;
        this.monthlySalary = monthlySalary;
        this.workplaceNumber = 0;
    }

    //Methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress () {
        return address;
    }

    public void setMonthlySalary (double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary () {
        return monthlySalary;
    }

    public void printPerson () {
        System.out.println("Name: "+name);
        System.out.println("Adress: "+address);
        System.out.println("Monthly Salary: "+monthlySalary);
        System.out.println("Annual Salary: "+calculateAnnualSalary(monthlySalary));
        System.out.println("Total workplaces: "+workplaceNumber);
    }

    //Beregner årsløn ud fra månedsløn + 2,5%
    public double calculateAnnualSalary (double monthlySalary) {
        double annualSalary;
        annualSalary = 12*monthlySalary*1.025;
        return annualSalary;
    }

    public void hireAt (String newWorkplace) {
        currentEmployment = newWorkplace;
        workplaceNumber = workplaceNumber+1;
    }

}
