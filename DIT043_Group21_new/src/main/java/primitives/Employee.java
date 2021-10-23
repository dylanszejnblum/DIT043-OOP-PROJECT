package primitives;

import helpers.MathHelpers;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private String ID; //should this be final?
    private String name;
    protected double initialGrossSalary;
    final double TAX_PERCENTAGE = 0.1;
    private String degree = null;
    final double PERCENT_BSC = 1.1;
    final double PERCENT_MSC = 1.2;
    final double PERCENT_PHD = 1.35;

    public Employee( String ID, String name, double initialGrossSalary) throws Exception{

        if (ID.isEmpty()){
            throw new Exception("ID cannot be blank.");
        }
        else {
            this.ID = ID;
        }

        if (name.isEmpty()){
            throw new Exception("Name cannot be blank.");
        }

        else {
            this.name = name;
        }

        if (initialGrossSalary < 0){
            throw new Exception("Salary must be greater than zero.");
        }

        else {
            this.initialGrossSalary = MathHelpers.truncateDouble(initialGrossSalary);
        }

    }

    public Employee( String ID, String name, double initialGrossSalary, String degree) throws Exception{

        this(ID, name, initialGrossSalary);
        if (degree != "BSc" && degree!= "MSc" && degree!= "PhD"){
            throw new Exception("Degree must be one of the options: PhD, MSc or PhD.");
        }
        this.degree = degree;

    }

    public double getGrossSalary() {
        if (this.degree == null){
            return initialGrossSalary;
        }
        switch (this.degree) {
            case "BSc": return initialGrossSalary* PERCENT_BSC;
            case "MSc": return initialGrossSalary* PERCENT_MSC;
            case "PhD": return initialGrossSalary* PERCENT_PHD;
        }
        return initialGrossSalary;
    }

    public String getDegree(){return this.degree;}
    public void setDegree(String newDegree){this.degree = newDegree;}
    public String getName(){
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public double getInitialGrossSalary(){
        return this.initialGrossSalary;
    }
    public void setInitialGrossSalary(double newGrossSalary) {
        this.initialGrossSalary = newGrossSalary;
    }

    public double getEmployeeRawSalary(){
        return this.initialGrossSalary;
    }

    public String getID() {
        return this.ID;
    }



    public boolean equals(Employee anotherEmployee){
        if(anotherEmployee == this){
            return true;

        } else if(anotherEmployee == null){
            return false;

        } else {
            return (this.getID().equals(anotherEmployee.getID()));
        }
    }

    public double calculateNetSalary(){
        return MathHelpers.truncateDouble(this.getGrossSalary() - (0.1 * this.getGrossSalary()));

    }

    public String toString() {
        return this.getName()+"'s gross salary is "+String.format("%.2f",this.getGrossSalary())+" SEK per month.";
    }

    @Override
    public int compareTo(Employee o2) {
        return (int) Double.compare(this.getInitialGrossSalary(),(o2.getInitialGrossSalary()));
    }




}