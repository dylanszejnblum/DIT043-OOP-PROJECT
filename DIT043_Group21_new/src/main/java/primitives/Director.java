package primitives;

import helpers.MathHelpers;

public class Director extends Manager{

    private String department;

    public Director(final String ID, String name, double initialGrossSalary, String degree, String department) throws Exception {
        super(ID, name, initialGrossSalary, degree);
        if (!department.equals("Business")&&!department.equals("Human Resources")&& !department.equals("Technical")){
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
        this.department = department;
    }

    public String getDepartment(){return this.department;}
    public void setDepartment(String newDepartment){this.department = newDepartment;}

    public double getGrossSalary(){
        return super.getGrossSalary()+ 5000.0;
    }


    //changed it from initialGrossSalary to this.grossSalary.
    public double calculateNetSalary(){
        double grossSalary = this.getGrossSalary();
        double netSalary = 0.0;

        if (grossSalary < 30000){
            netSalary = grossSalary - (grossSalary * 0.1);
        }
        else if (grossSalary <= 50000){
            netSalary = grossSalary  - (grossSalary * 0.2);
        }
        else {
            double newValue = grossSalary - 30000;
            netSalary = grossSalary  - (30000*0.2) - (newValue * 0.4);
        }
        return netSalary;
    }

    public String toString(){
        return this.getDegree() + " " +this.getName() + "'s gross salary is " + String.format("%.2f", MathHelpers.truncateDouble(getGrossSalary())) + " SEK per month. Dept: " + this.department;
    }

}
