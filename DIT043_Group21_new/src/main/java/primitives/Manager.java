package primitives;

import helpers.MathHelpers;

public class Manager extends Employee{
    private String degree;
    final double PERCENT_BSC = 0.1;
    final double PERCENT_MSC = 0.2;
    final double PERCENT_PHD = 0.35;


    public Manager( String ID, String name, double initialGrossSalary, String degree) throws Exception {
        super(ID, name, initialGrossSalary);
        if (degree != "BSc" && degree!= "MSc" && degree!= "PhD"){
            throw new Exception("Degree must be one of the options: PhD, MSc or PhD.");
        }
        this.degree = degree;
    }

    public double getGrossSalary() {
        switch (this.degree) {
            case "BSc": return MathHelpers.truncateDouble(initialGrossSalary + (initialGrossSalary* 0.1));
            case "MSc": return MathHelpers.truncateDouble(initialGrossSalary + (initialGrossSalary* 0.2));
            case "PhD": return MathHelpers.truncateDouble(initialGrossSalary + (initialGrossSalary* 0.35));
        }
        return initialGrossSalary;
    }
    public String getDegree(){return this.degree;}
    public void setDegree(String newDegree){this.degree = newDegree;}


    public String toString(){
        return this.degree + this.getName() + "'s gross salary is " + this.getGrossSalary() + " SEK per month";
    }

}
