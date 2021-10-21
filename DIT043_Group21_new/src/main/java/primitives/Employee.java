package primitives;

import helpers.MathHelpers;

public class Employee implements Comparable<Employee> {

    final String ID;
    private String name;
    protected double initialGrossSalary;
    final double TAX_PERCENTAGE = 0.1;
    private double netSalary;
    public MathHelpers mathHelpers;


    public Employee(final String ID, String name, double initialGrossSalary) {
        this.ID = ID;
        this.name = name;
        this.initialGrossSalary = MathHelpers.truncateDouble(initialGrossSalary);
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
    public double getNetSalary(){return this.netSalary;}
    public void setNetSalary(double newNetSalary){this.netSalary = newNetSalary;}
    public double getTAX_PERCENTAGE(){return TAX_PERCENTAGE;}




    public boolean equals(Employee anotherEmployee){
        if(anotherEmployee == this){
            return true;

        } else if(anotherEmployee == null){
            return false;

        } else if ( anotherEmployee instanceof Employee ){
            return (this.getID().equals(anotherEmployee.getID()));

        } else {
            return false;
        }
    }


    public String toString() {
        return this.getName() + "'s gross salary is " + this.getInitialGrossSalary() + " SEK per month";
    }

    public String createEmployee (String ID, String name, double grossSalary) {
        Employee employee = new Employee(ID, name, grossSalary);
        return "Employee " + this.getID() + " registered successfully.";

    }

    public double calculateNetSalary() {
        double netSalary = 0.0;
        netSalary = this.initialGrossSalary - (this.initialGrossSalary * TAX_PERCENTAGE);
        return netSalary;
        // Add the truncate function into the helpers
    }

    @Override
    //is it getInitialGrossSalary or grossSalary here??
    public int compareTo(Employee anotherEmployee) {
        if (anotherEmployee.getInitialGrossSalary() > this.getInitialGrossSalary()) {
            return 1;
        }
        else if(anotherEmployee.getInitialGrossSalary() < this.getInitialGrossSalary()){
            return -1;
        }
        else{
            return 0;
        }
    }
}