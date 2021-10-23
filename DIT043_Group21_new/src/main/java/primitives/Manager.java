package primitives;

import helpers.MathHelpers;

public class Manager extends Employee{

    public Manager( String ID, String name, double initialGrossSalary, String degree) throws Exception {
        super(ID, name, initialGrossSalary, degree);
    }

    public String toString(){
        return getDegree() +" "+ this.getName() + "'s gross salary is " + String.format("%.2f",MathHelpers.truncateDouble(getGrossSalary())) + " SEK per month.";
    }
}
