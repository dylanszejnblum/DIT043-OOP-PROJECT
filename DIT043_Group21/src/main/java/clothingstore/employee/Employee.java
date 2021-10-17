package clothingstore.employee;
import clothingstore.Methods;

public class Employee {

    public Methods methods;

    private String ID;
    private String name;
    private double grossSalary;

    public Employee(String ID, String name, double grossSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = methods.truncateValue(grossSalary);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public double getGrossSalary(){
        return this.grossSalary;
    }
    public void setGrossSalary(double newGrossSalary) {
        this.grossSalary = newGrossSalary;
    }
    public String getID() {
        return this.ID;
    }

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
        return this.getName() + "'s gross salary is " + this.getGrossSalary() + " SEK per month";
    }

    public String createEmployee (String ID, String name, double grossSalary) {
        Employee employee = new Employee(ID, name, grossSalary);
        return "Employee " + this.getID() + " registered successfully.";
        
    }

    public double calculateNetSalary() {
        double netSalary = 0.0;
        netSalary = netSalary - (this.grossSalary*0.1);
        return (methods.truncateValue(netSalary));
    }


}
