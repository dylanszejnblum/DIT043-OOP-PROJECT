package controllers;
import primitives.*;
import java.util.ArrayList;
import java.util.Collections;

import exceptions.*;
import helpers.*;
import primitives.Employee;

public class EmployeeController  {

    public Employee employee;
    public ArrayList<Employee> employees;
    public ArrayList<Employee> sortedEmployees;

    public EmployeeController(){

        employees = new ArrayList<Employee>();
        sortedEmployees = new ArrayList<Employee>();
    }

    //method for retrieving an Employee by its ID.\\

    public boolean employeeExists(String ID) throws Exception{
        for(int i = 0 ; i< employees.size(); i++){
            Employee e = employees.get(i);
            if(e.getID().equals(ID)){
                return true;
            }
        }
        throw new Exception("No employee has been registered yet.") ;
    }

    public Employee getEmployeeById(String ID) throws Exception{

        for(int i = 0; i < employees.size() ; i++){
            if(employees.get(i).getID().equals(ID)){
                return employees.get(i);
            }
        }
        //how to try and catch the error
        throw new Exception("Employee "+ ID +" was not registered yet.");
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


        // Add the truncate function into the helpers


    //----------CREATE METHODS FOR EVERY KIND OF EMPLOYEES----------\\
    public boolean checkName(String employee){
        for (int i = 0; i < employee.length();i++){
            int ascii = (int) employee.charAt(i);
            if (ascii != 32){
                return false;
            }
        }
        return true;
    }
    public String createEmployee (String ID, String name, double initialGrossSalary) throws Exception {
        if (name.isEmpty() || checkName(name)){
            throw new BlankNameException();
        }
        Employee newEmployee = new Employee(ID, name, initialGrossSalary);
        employees.add(newEmployee);
        return "Employee " + newEmployee.getID() + " was registered successfully.";
    }


    public String createManager(String ID, String name, double initialGrossSalary, String degree) throws Exception {
        if (name.isEmpty() || checkName(name)){
            throw new BlankNameException();
        }
        Employee managerEmployee = new Manager(ID, name ,initialGrossSalary, degree);
        employees.add(managerEmployee);
         return "Employee " + managerEmployee.getID() + " was registered successfully.";
    }


    public String createDirector(String ID, String name, double initialGrossSalary,String degree, String department) throws Exception {
        if (name.isEmpty() || checkName(name)){
            throw new BlankNameException();
        }
        Employee directorEmployee = new Director(ID, name, initialGrossSalary, degree, department);
        employees.add(directorEmployee);
      return "Employee " + directorEmployee.getID() + " was registered successfully.";
    }


    public String createIntern(String ID, String name, double initialGrossSalary,int gpa) throws Exception {
        if (name.isEmpty() || checkName(name)){
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
    public String removeStoredEmployees(String ID) {
        for (int i = 0; i < employees.size(); i++) {

            if (ID.equals(employees.get(i).getID())) {
                employees.remove(employees.get(i));

                return "Employee " + ID + " was successfully removed.";
            }
          } return "";}  //idk what to return if it's not removed successfully.}



    //printing specific employee - 5.5\\
    public String printSpecificEmployee(String ID) throws Exception {
        if(employeeExists(ID)) {
            return getEmployeeById(ID).toString();
        }
        return "No employee with such an ID"; //not sure what should be printed in this case.
    }


        //checker if an employee with such an ID exists\\
        public boolean checker(String ID){

        for(int i = 0; i<employees.size(); i++){
            if(ID.equals(employees.get(i).getID())){return true;}
        }
        return false;
        }


        //printing all employees - 5.6\\

        public String printAllEmployees() throws Exception{
        if (employees.size() == 0){
            throw new EmptyIdException();
        }
        String result = "";
        for (int i = 0; i < employees.size(); i++){
            result += employees.get(i).toString() + "\n";
        }
        return "All registered employees: \n" + result;
        }


        //print total salary expenses - 5.7\\

        public double printTotalSalaryExpenses() throws Exception{
            double total = 0.0;
            if (employees.size() == 0){
                throw new EmptyIdException();
            }
            for(int i = 0; i < employees.size(); i++){
                total += employees.get(i).calculateNetSalary();
            }
            return total;
        }

        //print employees sorted by gross salary - 5.8\\
        public String printSortedEmployees() throws Exception{
            if (employees.size() == 0){
                throw new EmptyIdException();
            }
            String result = "Employees sorted by gloss salary (ascending order): \n";
            ArrayList<Employee> sortedEmployees = employees;
            Collections.sort(sortedEmployees);
            for (Employee currentEmployee : sortedEmployees) {
                result += currentEmployee + "\n";
            }
            return result;
        }

    //---------------------update employee's information - 5.9------------------------\\


//--------update employee's name----------\\

    public String updateEmployeeName(String ID, String name) throws Exception {
        if (name.isEmpty() || checkName(name)){
            throw new BlankNameException();
        }
        Employee employee = getEmployeeById(ID);
        employee.setName(name);
        return "Employee " + ID + "was updated successfully";
    }



//--------update employee's initialGrossSalary----------\\

    public String updateEmployeeInitialGrossSalary(String ID, double initialGrossSalary) throws Exception {
        Employee employee = getEmployeeById(ID);
        employee.setInitialGrossSalary(initialGrossSalary);
        return "Employee " + ID + "was updated successfully";
    }




//--------update employee's degree----------\\

    public String updateEmployeeDegree(String ID, String degree) throws Exception {
        Employee employee = getEmployeeById(ID);
        if (employee instanceof Manager) {
            ((Manager) employee).setDegree(degree);
            return "Employee " + ID + "was updated successfully";

        } else if (employee instanceof Director) {
            ((Director) employee).setDegree(degree);
            return "Employee " + ID + "was updated successfully";
        } 
    }



//--------update employee's department----------\\

    public String updateEmployeeDepartment(String ID, String department) throws Exception {
        Employee employee = getEmployeeById(ID);
        if (employee == null) {
            return "Update unsuccessful.No employee existing with that ID";
        }
        if (employee instanceof Director) {
            ((Director) employee).setDepartment(department);
            return "Employee " + ID + "was updated successfully";
        }
        return "Employee " + ID + "does not have a department";
    }



//--------update employee's gpa----------\\


    public String updateEmployeeGpa(String ID, int gpa) throws Exception {
        Employee employee = getEmployeeById(ID);
        if (employee == null) {
            return "Update unsuccessful.No employee existing with that ID";
        }
        if (employee instanceof Intern) {
            ((Intern) employee).setGpa(gpa);
            return "Employee " + ID + "was updated successfully";
        }
        return "Employee " + ID + "does not have a gpa";

    }

    public String printNumOfEmployeesPerDegree(){
        String result = "Academic background of employees:";
        String degree = "";
        int counterBsc = 0;
        int counterMsc = 0;
        int counterPhd = 0;

        for(int i = 0; i<employees.size(); i++) {

            if (employees.get(i) instanceof Manager || employees.get(i) instanceof Director) {
                degree = ((Manager) employees.get(i)).getDegree();

                if (degree.equals("BSc")) {
                    counterBsc++;

                } else if (degree.equals("MSc")) {
                    counterMsc++;

                } else {
                    counterPhd++;
                }

                return result + "\n BSc: => " + counterBsc +
                        "\n MSc: => " + counterMsc +
                        "\n PhD: => " + counterPhd;

            }
        }

        return result;
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
    public String promoteToManager(String degree, String ID) throws Exception{

        String result = "";
        if (!degree.equals("PhD") && !degree.equals("BSc")&& !degree.equals("MSc")) {
            throw new Exception("Degree must be one of the options: PhD, MSc or PhD");
        }

        if (ID.isEmpty()){
            throw new Exception("ID cannot be blank.");
        }

        if (employeeExists(ID)) {
            Employee inputEmployee = getEmployeeById(ID);
            Employee manager = new Manager(ID, inputEmployee.getName(), inputEmployee.getInitialGrossSalary(), degree);
            int pastIndex = employees.indexOf(inputEmployee);
            employees.set(pastIndex, manager);
            result = ID + " promoted successfully to Manager.";
            return result;

        }
        else {
            throw new Exception("Employee " + ID + " was not registered yet.");
        }

    }

    public String promoteToDirector(String department, String ID, String degree) throws Exception{

        String result = "";
        if (!department.equals("Business") && !department.equals("Human Resources") && !department.equals("Technical") ) {
            throw new Exception("Department must be one of the options: Business, Human Resources or Technical.");
        }

        if (!degree.equals("PhD") && !degree.equals("BSc")&& !degree.equals("MSc")) {
            throw new Exception("Degree must be one of the options: PhD, MSc or PhD");
        }

        if (ID.isEmpty()){
            throw new Exception("ID cannot be blank.");
        }

        if (employeeExists(ID)) {
            Employee inputEmployee = getEmployeeById(ID);
            Employee director = new Director(ID, inputEmployee.getName(), inputEmployee.getInitialGrossSalary(), degree ,department);
            int pastIndex = employees.indexOf(inputEmployee);
            employees.set(pastIndex, director);
            result = ID + " promoted successfully to Director.";
            return result;

        }
        else {
            throw new Exception("Employee " + ID + " was not registered yet.");
        }

    }

    public String promoteToIntern(String ID, int gpa) throws Exception{
        String result = "";

        if (ID.isEmpty()){
            throw new Exception("ID cannot be blank.");
        }

        if (employeeExists(ID)) {
            Employee inputEmployee = getEmployeeById(ID);
            Employee intern = new Intern(ID, inputEmployee.getName(), inputEmployee.getInitialGrossSalary(), gpa);
            int pastIndex = employees.indexOf(inputEmployee);
            employees.set(pastIndex, intern);
            result = ID + " promoted successfully to Intern.";
            return result;

        }
        else {
            throw new Exception("Employee " + ID + " was not registered yet.");
        }
    }
}










