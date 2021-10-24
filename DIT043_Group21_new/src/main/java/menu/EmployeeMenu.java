package menu;

import controllers.EmployeeController;
import helpers.UserInput;

public class EmployeeMenu {

    public static void printEmployeeMenu() {
        System.out.println("Item options menu:\n" +
                "0. Return to Main Menu.\n" +
                "1. Create an employee (Regular Employee).\n\n" +
                "2. Create an employee (Manager).\n" +
                "3. Create an employee (Director).\n" +
                "4. Create an employee (Intern).\n" +
                "5. Remove an employee.\n" +
                "6. Print specific employee.\n" +
                "7. Print all registered employees.\n" +
                "\n");
    }

    public static void employeeOptionsMenu(int option, EmployeeController employeeController) throws Exception {
        String ID;
        String name;
        double initialGrossSalary;
        String degree;
        String department;
        int gpa;
        do{
            switch (option){
                case 0:

                    break;

                case 1:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    name = UserInput.readString("Introduce the desired name: ");
                    initialGrossSalary = UserInput.readDouble("Introduce the desired initial gross salary: ");
                    employeeController.createEmployee(ID, name, initialGrossSalary);
                    System.out.println("Employee " + ID + " has been registered successfully.");
                    printEmployeeMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 2:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    name = UserInput.readString("Introduce the desired name: ");
                    initialGrossSalary = UserInput.readDouble("Introduce the desired initial gross salary: ");
                    degree = UserInput.readString("Introduce the desired degree (BSc, MSc or PhD): ");
                    employeeController.createManager(ID, name, initialGrossSalary, degree);
                    System.out.println("Manager " + ID + " has been registered successfully.");
                    printEmployeeMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 3:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    name = UserInput.readString("Introduce the desired name: ");
                    initialGrossSalary = UserInput.readDouble("Introduce the desired initial gross salary: ");
                    degree = UserInput.readString("Introduce the desired degree (BSc, MSc or PhD): ");
                    department = UserInput.readString("Introduce the desired department (Business, Human Resources or Technical): ");
                    employeeController.createDirector(ID, name, initialGrossSalary, degree, department );
                    System.out.println("Director " + ID + " has been registered successfully.");
                    printEmployeeMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 4:
                    ID = UserInput.readString("Introduce the desired ID: ");
                    name = UserInput.readString("Introduce the desired name: ");
                    initialGrossSalary = UserInput.readDouble("Introduce the desired initial gross salary: ");
                    gpa = UserInput.readInt("Introduce the desired gpa (0-10): ");
                    employeeController.createIntern(ID, name, initialGrossSalary, gpa );
                    System.out.println("Intern " + ID + " has been registered successfully.");
                    printEmployeeMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 5:
                    ID = UserInput.readString("Introduce the desired ID to remove: ");
                    employeeController.removeStoredEmployees(ID);
                    System.out.println("Employee " + ID + " has been removed successfully.");
                    printEmployeeMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 6:
                    ID = UserInput.readString("Introduce the desired ID to print: ");
                    System.out.println(employeeController.printSpecificEmployee(ID));
                    printEmployeeMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                case 7:
                    System.out.println(employeeController.printAllEmployees());
                    printEmployeeMenu();
                    option = UserInput.readInt("Enter your choice: ");
                    break;

                default:
                    System.out.println("Invalid menu option. Please type another option");
                    option = UserInput.readInt("Enter your choice: ");
                    break;
            }


        }while (option !=0);
    }



}
