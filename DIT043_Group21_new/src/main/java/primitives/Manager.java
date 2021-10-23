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
            case "BSc": return initialGrossSalary + (initialGrossSalary* PERCENT_BSC);
            case "MSc": return initialGrossSalary + (initialGrossSalary* PERCENT_MSC);
            case "PhD": return initialGrossSalary + (initialGrossSalary* PERCENT_PHD);
        }
        return initialGrossSalary;
    }

    public String getDegree(){return this.degree;}
    public void setDegree(String newDegree){this.degree = newDegree;}


    public String toString(){
        return this.degree +" "+ this.getName() + "'s gross salary is " + String.format("%.2f", MathHelpers.truncateDouble(getGrossSalary())) + " SEK per month.";
    }

}
