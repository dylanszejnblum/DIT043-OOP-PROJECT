package primitives;

import helpers.MathHelpers;

public class Manager extends Employee{
    private String degree;
    final double PERCENT_BSC = 0.1;
    final double PERCENT_MSC = 0.2;
    final double PERCENT_PHD = 0.35;
    double grossSalary;

    public Manager( String ID, String name, double initialGrossSalary, String degree){
        super(ID, name, initialGrossSalary);
        this.degree = degree;
    }

    public double getGrossSalaryWithBonus() {
        switch (this.degree) {

            case "BSc": return MathHelpers.truncateDouble(grossSalary = initialGrossSalary * 1.1);
            case "MSc": return MathHelpers.truncateDouble(grossSalary = initialGrossSalary * 1.2);
            case "PhD": return MathHelpers.truncateDouble(grossSalary = initialGrossSalary * 1.35);
        }
        return this.grossSalary;
    }
    public String getDegree(){return this.degree;}
    public void setDegree(String newDegree){this.degree = newDegree;}


    public String toString(){
        return this.degree + this.getName() + "'s gross salary is " + this.grossSalary + " SEK per month";
    }

}
