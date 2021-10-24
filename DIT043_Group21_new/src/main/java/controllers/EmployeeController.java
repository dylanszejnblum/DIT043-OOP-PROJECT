package controllers;

import primitives.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import exceptions.*;
import helpers.*;
import primitives.Employee;

public class EmployeeController {

    public Employee employee;
    public ArrayList<Employee> employees;
    public ArrayList<Employee> sortedEmployees;

    public EmployeeController() {

        employees = new ArrayList<Employee>();
        sortedEmployees = new ArrayList<Employee>();
    }

    //method for retrieving an Employee by its ID.\\

    public boolean employeeExists(String ID) throws Exception {
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.getID().equals(ID)) {
                return true;
            }
        }
        throw new Exception("Employee " + ID + " was not registered yet.");
    }

    public Employee getEmployeeById(String ID) throws Exception {

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getID().equals(ID)) {
                return employees.get(i);
            }
        }
        //how to try and catch the error
        throw new Exception("Employee " + ID + " was not registered yet.");
    }

    public boolean equals(Employee anotherEmployee) {
        if (anotherEmployee == this.employee) {
            return true;

        } else if (anotherEmployee == null) {
            return false;

        } else if (anotherEmployee instanceof Employee) {
            return (this.employee.getID().equals(anotherEmployee.getID()));

        } else {
            return false;
        }
    }

    public Map<String, Integer> getNumberOfEmployeesPerDegree() throws Exception{
        if (employees.size() == 0) {
            throw new Exception("No employees registered yet.");
        }
        HashMap<String, Integer> numberOfEmployeesPerDegree = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            String degree = employee.getDegree();
            if (degree != null) {
                if (!numberOfEmployeesPerDegree.containsKey(degree)) {
                    numberOfEmployeesPerDegree.put(degree, 0);
                }
                numberOfEmployeesPerDegree.put(degree, numberOfEmployeesPerDegree.get(degree) + 1);
            }
        }

        return numberOfEmployeesPerDegree;
    }

    public String toString() {
        return this.employee.getName() + "'s gross salary is " + this.employee.getInitialGrossSalary() + " SEK per month";
    }


    // Add the truncate function into the helpers


    //----------CREATE METHODS FOR EVERY KIND OF EMPLOYEES----------\\
    public boolean checkName(String employee) {
        for (int i = 0; i < employee.length(); i++) {
            int ascii = (int) employee.charAt(i);
            if (ascii != 32) {
                return false;
            }
        }
        return true;
    }

    public String createEmployee(String ID, String name, double initialGrossSalary) throws Exception {
        validateID(ID);
        validateName(name);
        validateSalary(initialGrossSalary);
        Employee newEmployee = new Employee(ID, name, initialGrossSalary);
        employees.add(newEmployee);
        return "Employee " + newEmployee.getID() + " was registered successfully.";
    }


    public String createManager(String ID, String name, double initialGrossSalary, String degree) throws Exception {
        validateID(ID);
        validateName(name);
        validateSalary(initialGrossSalary);
        validateDegree(degree);
        Employee managerEmployee = new Manager(ID, name, initialGrossSalary, degree);
        employees.add(managerEmployee);
        return "Employee " + managerEmployee.getID() + " was registered successfully.";
    }


    public String createDirector(String ID, String name, double initialGrossSalary, String degree, String department) throws Exception {
        validateID(ID);
        validateName(name);
        validateSalary(initialGrossSalary);
        validateDegree(degree);
        validateDepartment(department);
        Employee directorEmployee = new Director(ID, name, initialGrossSalary, degree, department);
        employees.add(directorEmployee);
        return "Employee " + directorEmployee.getID() + " was registered successfully.";
    }


    public String createIntern(String ID, String name, double initialGrossSalary, int gpa) throws Exception {
        validateID(ID);
        validateName(name);
        validateSalary(initialGrossSalary);
        validateGpa(gpa);
        if (name.isEmpty() || checkName(name)) {
            throw new BlankNameException();
        }
        Employee internEmployee = new Intern(ID, name, initialGrossSalary, gpa);
        employees.add(internEmployee);
        return "Employee " + internEmployee.getID() + " was registered successfully.";
    }

    // --------------------------------------------------------------------------\\

    //getNetSalary\\

    public double getNetSalary(String ID) throws Exception {
        double finalNetSalary = 0.0;
        if (!employeeExists(ID)) {
            return 0;
        } else {
            Employee employee = getEmployeeById(ID);
            finalNetSalary = employee.calculateNetSalary();
        }
        return finalNetSalary;
    }


    //removing stored employee 5.4\\
    /*
    public String removeStoredEmployees(String ID) {

        for (int i = 0; i < employees.size(); i++) {
            if (ID.equals(employees.get(i).getID())) {
                employees.remove(employees.get(i));

                return "Employee " + ID + " was successfully removed.";
            }
        } return "Employee "+ ID +" was not registered yet.";}  //idk what to return if it's not removed successfully.}

    */


    public String removeStoredEmployees(String ID) throws Exception {
        if (employeeExists(ID)) {
            Employee inputEmployee = getEmployeeById(ID);
            employees.remove(inputEmployee);
            return "Employee " + ID + " was successfully removed.";
        }
        return "Employee " + ID + " was not registered yet.";
    }


    //printing specific employee - 5.5\\
    public String printSpecificEmployee(String ID) throws Exception {
        if (employeeExists(ID)) {
            return getEmployeeById(ID).toString();
        }
        return "No employee with such an ID"; //not sure what should be printed in this case.
    }


    //checker if an employee with such an ID exists\\
    public boolean checker(String ID) {

        for (int i = 0; i < employees.size(); i++) {
            if (ID.equals(employees.get(i).getID())) {
                return true;
            }
        }
        return false;
    }


    //printing all employees - 5.6\\

    public String printAllEmployees() throws Exception {
        if (employees.size() == 0) {
            throw new Exception("No employees registered yet.");
        }
        String result = "";
        for (int i = 0; i < employees.size(); i++) {
            result += employees.get(i).toString() + "\n";
        }
        return "All registered employees:\n" + result;
    }

    public double getTotalNetSalary()throws Exception {
        if (employees.size() == 0) {
            throw new Exception("No employees registered yet.");
        }
        double totalNetSalary = 0.0;
        for (Employee currentEmployee : employees) {
            totalNetSalary += currentEmployee.calculateNetSalary();
        }

        return totalNetSalary;
    }


    //print total salary expenses - 5.7\\

    public double printTotalSalaryExpenses() throws Exception {
        double total = 0.0;
        if (employees.size() == 0) {
            throw new EmptyIdException();
        }
        for (int i = 0; i < employees.size(); i++) {
            total += employees.get(i).calculateNetSalary();
        }
        return total;
    }

    //print employees sorted by gross salary - 5.8\\
    public String printSortedEmployees() throws Exception {
        if (employees.size() == 0) {
            throw new Exception("No employees registered yet.");
        }
        String result = "Employees sorted by gross salary (ascending order):\n";
        ArrayList<Employee> sortedEmployees = employees;
        Collections.sort(sortedEmployees);
        for (int i = 0; i < sortedEmployees.size(); i++) {
            result += sortedEmployees.get(i).toString() + "\n";
        }

        return result;
    }

    //---------------------update employee's information - 5.9------------------------\\


//--------update employee's name----------\\

    public String updateEmployeeName(String ID, String name) throws Exception {
        validateName(name);
        Employee employee = getEmployeeById(ID);
        employee.setName(name);
        return "Employee " + ID + " was updated successfully";
    }


//--------update employee's initialGrossSalary----------\\

    public String updateEmployeeInitialGrossSalary(String ID, double initialGrossSalary) throws Exception {
        validateSalary(initialGrossSalary);
        Employee employee = getEmployeeById(ID);
        employee.setInitialGrossSalary(initialGrossSalary);
        return "Employee " + ID + " was updated successfully";
    }


//--------update employee's degree----------\\

    public String updateEmployeeDegree(String ID, String degree) throws Exception {
        validateDegree(degree);
        Employee employee = getEmployeeById(ID);
        if (employee instanceof Manager) {
            ((Manager) employee).setDegree(degree);
            return "Employee " + ID + " was updated successfully";

        } else if (employee instanceof Director) {
            ((Director) employee).setDegree(degree);
            return "Employee " + ID + " was updated successfully";
        }
        return "";
    }


//--------update employee's department----------\\

    public String updateEmployeeDepartment(String ID, String department) throws Exception {
        validateDepartment(department);
        Employee employee = getEmployeeById(ID);
        if (employee == null) {
            return "Update unsuccessful. No employee existing with that ID";
        }
        if (employee instanceof Director) {
            ((Director) employee).setDepartment(department);
            return "Employee " + ID + " was updated successfully";
        }
        return "Employee " + ID + " does not have a department";
    }


//--------update employee's gpa----------\\


    public String updateEmployeeGpa(String ID, int gpa) throws Exception {
        validateGpa(gpa);
        Employee employee = getEmployeeById(ID);
        if (employee == null) {
            return "Update unsuccessful.No employee existing with that ID";
        }
        if (employee instanceof Intern) {
            ((Intern) employee).setGpa(gpa);
            return "Employee " + ID + " was updated successfully";
        }
        return "Employee " + ID + "does not have a gpa";

    }




    /*
    public String updateEmployeeDegree(String ID, String degree) {

        Employee employee = getEmployeeById(ID);
        if (employee == null) {
            return "Update unsuccessful.No employee existing with that ID";
        }
        if (employee instanceof Manager || employee instanceof Director ) {
            ((Manager) employee).setDegree(degree);
            return "Employee " + ID + "was updated successfully";

        }
        return "Update unsuccessful. The employee does nor have a degree";
    }

     */


    //--------------------------PROMOTIONS---------------------------------------------
    public String promoteToManager(String ID, String degree) throws Exception {

        String result;

        if (!degree.equals("PhD") && !degree.equals("BSc") && !degree.equals("MSc")) {
            throw new Exception("Degree must be one of the options: PhD, MSc or PhD");
        }

        if (ID.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        }

        if (employeeExists(ID)) {
            Employee inputEmployee = getEmployeeById(ID);
            Employee manager = new Manager(ID, inputEmployee.getName(), inputEmployee.getInitialGrossSalary(), degree);
            int pastIndex = employees.indexOf(inputEmployee);
            employees.set(pastIndex, manager);
            result = ID + " promoted successfully to Manager.";
            return result;

        } else {
            throw new Exception("Employee " + ID + " was not registered yet.");
        }

    }

    public String promoteToDirector(String ID, String degree, String department) throws Exception {

        String result = "";
        if (!department.equals("Business") && !department.equals("Human Resources") && !department.equals("Technical")) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }

        if (!degree.equals("PhD") && !degree.equals("BSc") && !degree.equals("MSc")) {
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD");
        }

        if (ID.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        }

        if (employeeExists(ID)) {
            Employee inputEmployee = getEmployeeById(ID);
            Employee director = new Director(ID, inputEmployee.getName(), inputEmployee.getEmployeeRawSalary(), degree, department);
            int pastIndex = employees.indexOf(inputEmployee);
            employees.set(pastIndex, director);
            result = ID + " promoted successfully to Director.";
            return result;

        } else {
            throw new Exception("Employee " + ID + " was not registered yet.");
        }

    }

    public String promoteToIntern(String ID, int gpa) throws Exception {
        String result = "";

        if (ID.isEmpty()) {
            throw new Exception("ID cannot be blank.");
        }

        if (gpa < 0 || gpa > 10) {
            throw new Exception(gpa + " outside range. Must be between 0-10.");
        }

        if (employeeExists(ID)) {
            Employee inputEmployee = getEmployeeById(ID);
            Employee intern = new Intern(ID, inputEmployee.getName(), inputEmployee.getInitialGrossSalary(), gpa);
            int pastIndex = employees.indexOf(inputEmployee);
            employees.set(pastIndex, intern);
            result = ID + " promoted successfully to Intern.";
            return result;

        } else {
            throw new Exception("Employee " + ID + " was not registered yet.");
        }
    }

    private void validateName(String name) throws Exception{
        if (name.trim().isEmpty()){
            throw new Exception("Name cannot be blank.");
        }
    }

    private void validateID(String ID) throws Exception{
        if (ID.isEmpty()){
            throw new Exception("ID cannot be blank.");
        }
    }

    private void validateSalary(double salary) throws Exception{
        if (salary <= 0){
            throw new Exception("Salary must be greater than zero.");
        }
    }

    private void validateDegree(String degree) throws Exception{
        if (degree != "BSc" && degree!= "MSc" && degree!= "PhD"){
            throw new Exception("Degree must be one of the options: BSc, MSc or PhD.");
        }
    }

    private void validateDepartment(String department) throws Exception{
        if (!department.equals("Business")&&!department.equals("Human Resources")&& !department.equals("Technical")){
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }
    }

    private void validateGpa(int gpa) throws Exception{
        if (gpa < 0 || gpa > 10){
            throw new Exception(gpa + " outside range. Must be between 0-10.");
        }
    }

}










