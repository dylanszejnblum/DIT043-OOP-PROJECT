package primitives;

import helpers.MathHelpers;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

    private String ID; //should this be final?
    private String name;
    protected double initialGrossSalary;
    final double TAX_PERCENTAGE = 0.1;

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
            this.initialGrossSalary = initialGrossSalary;
        }

    }

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
    public String getID() {
        return this.ID;
    }

    public double getTAX_PERCENTAGE(){return TAX_PERCENTAGE;}


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
        return this.getInitialGrossSalary() - (0.1 * this.getInitialGrossSalary());

    }

    public String toString() {
        return this.getName()+"'s gross salary is "+String.format("%.2f", MathHelpers.truncateDouble(this.getInitialGrossSalary()))+" SEK per month.";
    }

    /*
    public String createEmployee (String ID, String name, double grossSalary) throws Exception {
        Employee employee = new Employee(ID, name, grossSalary);
        return "Employee " + this.getID() + " registered successfully.";

    }

     */

    @Override
    public int compareTo(Employee o2) {
        return (int) Double.compare(this.getInitialGrossSalary(),(o2.getInitialGrossSalary()));
    }


    /*@Override
    //is it getInitialGrossSalary or grossSalary here??
    public int compareTo(Employee anotherEmployee) {
        if (anotherEmployee.getInitialGrossSalary() > this.getInitialGrossSalary()) {
            return -1;
        }
        else if(anotherEmployee.getInitialGrossSalary() <= this.getInitialGrossSalary()){
            return 1;
        }
        else{
            return 0;
        }
    }*/
}