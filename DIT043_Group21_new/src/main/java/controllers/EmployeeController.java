package controllers;
import primitives.*;
import java.util.ArrayList;
import helpers.*;

public class EmployeeController {

    public Employee employee;
    public ArrayList<Employee> employees;


    public EmployeeController(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
    }

    public boolean equals(Employee anotherEmployee){
        if(anotherEmployee == this.employee){
            return true;

        } else if(anotherEmployee == null){
            return false;

        } else if ( anotherEmployee instanceof Employee ){
            return (this.employee.getID().equals(anotherEmployee.getID()));

        } else {
            return false;
        }
    }

    

    public String toString() {
        return this.employee.getName() + "'s gross salary is " + this.employee.getInitialGrossSalary() + " SEK per month";
    }

    public String createEmployee (String ID, String name, double grossSalary) {
        Employee employee = new Employee(ID, name, grossSalary);
        return "Employee " + this.employee.getID() + " registered successfully.";

    }

    public double calculateNetSalary() {
        double finalNetSalary = 0.0;
        finalNetSalary= employee.getNetSalary() - (this.employee.getInitialGrossSalary() * employee.getTAX_PERCENTAGE());
        return MathHelpers.truncateDouble(finalNetSalary);
        // Add the truncate function into the helpers
    }


}
