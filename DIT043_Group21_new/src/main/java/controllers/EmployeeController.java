package controllers;
import primitives.*;
import java.util.ArrayList;
import helpers.*;
import primitives.Employee;


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

    public double calculateNetSalary() {
        double finalNetSalary = 0.0;
        finalNetSalary= employee.getNetSalary() - (this.employee.getInitialGrossSalary() * employee.getTAX_PERCENTAGE());
        return MathHelpers.truncateDouble(finalNetSalary);
        // Add the truncate function into the helpers
    }


              //------CREATE METHODS FOR EVERY KIND OF EMPLOYEES------\\


    public String createEmployee (String ID, String name, double initialGrossSalary) {
        Employee employee = new Employee(ID, name, initialGrossSalary);
        employees.add(employee);
        return "Employee " + this.employee.getID() + " registered successfully.";
    }


    public String createManager(String ID, String name, double initialGrossSalary, String degree){
        Employee managerEmployee = new Manager(ID, name ,initialGrossSalary, degree);
        employees.add(managerEmployee);
         return "Employee " + managerEmployee.getID() + " registered successfully.";
    }


    public String createDirector(String ID, String name, double initialGrossSalary,String degree, String department){
        Employee directorEmployee = new Director(ID, name, initialGrossSalary, degree, department);
        employees.add(directorEmployee);
      return "Employee " + directorEmployee.getID() + " registered successfully.";
    }


    public String createIntern(String ID, String name, double initialGrossSalary,int gpa){
        Employee internEmployee = new Intern(ID, name, initialGrossSalary, gpa);
        employees.add(internEmployee);
        return "Employee " + internEmployee.getID() + " registered successfully.";
    }

         // --------------------------------------------------------------------------\\

}



