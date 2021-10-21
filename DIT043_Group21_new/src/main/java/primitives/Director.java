package primitives;

public class Director extends Manager{

    private String department;

    public Director(final String ID, String name, double initialGrossSalary, String degree, String department){
        super(ID, name, initialGrossSalary, degree);
        this.department = department;
    }

    public String getDepartment(){return this.department;}
    public void setDepartment(String newDepartment){this.department = newDepartment;}

    public double getGrossSalary(){
        return super.getInitialGrossSalary() + 5000.0;
    }


    //changed it from initialGrossSalary to this.grossSalary.
    public double netSalary(){
        double netSalary = 0.0;

        if (this.grossSalary < 30000){
            netSalary = this.grossSalary - (this.grossSalary* 0.1);
        }
        else if (this.grossSalary <= 50000){
            netSalary = this.grossSalary - (this.grossSalary*0.2);
        }
        else {
            double newValue = this.grossSalary - 30000;
            netSalary = this.grossSalary - (30000*0.2) - (newValue * 0.4);
        }
        return netSalary;
    }

    public String toString(){
        return this.getDegree() + " " +this.getName() + "'s gross salary is " + this.initialGrossSalary + " SEK per month. Dept: " + this.department;
    }

}
