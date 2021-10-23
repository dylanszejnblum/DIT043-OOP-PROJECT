package facade;

import controllers.EmployeeController;
import controllers.StoreController;
import primitives.Item;

import java.util.List;
import java.util.Map;

public class Facade {

    //Declare the objects ("this is what we are gonna have")
    public StoreController storeController;
    public EmployeeController employeeController;
    public Item item;

    // This class only has the skeleton of the methods used by the test.
    // You must fill in this class with your own code. You can (and should) create more classes
    // that implement the functionalities listed in the Facade and in the Test Cases.

    public Facade(){
        //Declare stuff in here
        //Create here the object
        storeController = new StoreController();
        employeeController = new EmployeeController();
    }



    public String createItem(String itemID, String itemName, double unitPrice){
        return storeController.createValidItem(itemID, itemName, unitPrice);
    }

    public String printItem(String itemID) {
        return storeController.printSpecificItem(itemID);
    }

    public String removeItem(String itemID) {
        return storeController.removeValidItem(itemID);
    }

    public boolean containsItem(String itemID) {
        return false;
    }

    public double buyItem(String itemID, int amount) {
        return storeController.buyItem(itemID ,amount);
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        return storeController.createReviews(itemID, reviewComment, reviewGrade );
    }

    public String reviewItem(String itemID, int reviewGrade) {
        return storeController.createReviews(itemID, " ", reviewGrade);
    }

    public String getItemCommentsPrinted(String itemID) {
        return "";
    }

    public List<String> getItemComments(String itemID) {
        return storeController.getItemComment(itemID);
    }

    public double getItemMeanGrade(String itemID) {
        return storeController.getMeanItemGrade(itemID);
    }

    public int getNumberOfReviews(String itemID) {
        return storeController.getItemReviewById(itemID);
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        return storeController.getSpecificReviewFromItem(itemID , reviewNumber);
    }

    public String getPrintedReviews(String itemID) {
        return storeController.getReviewsForItem(itemID);
    }

    public String printMostReviewedItems() {
        return storeController.printMostReviewedItems();
    }

    public List<String> getMostReviewedItems() {
        return storeController.getItemsWithMostReviews();
    }

    public List<String> getLeastReviewedItems() {
        return storeController.getItemsWithLeastReviews();
    }

    public String printLeastReviewedItems() {
        return storeController.printLeastReviewedItems();
    }

    public double getTotalProfit() {
        return storeController.totalPurchases();
    }

    public String printItemTransactions(String itemID) {
        return storeController.getAllItemTransactions(itemID);
    }

    public int getTotalUnitsSold() {
        return  storeController.totalUnits();
    }

    public int getTotalTransactions() {
        return storeController.totalTransaction();
    }

    public double getProfit(String itemID) {
        return storeController.getSpecificItemProfit(itemID);
    }

    public int getUnitsSolds(String itemID) {
        return storeController.getSpecificItemAmmount(itemID);
    }

    public String printAllTransactions() {
        return storeController.printAllTransactions();
    }

    public String printWorseReviewedItems() {
        return "";
    }

    public String printBestReviewedItems() {
        return "";
    }

    public List<String> getWorseReviewedItems() {
        return null;
    }

    public List<String> getBestReviewedItems() {
        return storeController.getItemsWithBestMeanReviews();
    }

    public String printAllReviews() {
        return storeController.printAllReviews();
    }

    public String updateItemName(String itemID, String newName) {

        return storeController.updateNameItem(itemID, newName);
    }

    public String updateItemPrice(String itemID, double newPrice) {
        return  storeController.updateItemPrice(itemID, newPrice);
    }

    public String printAllItems() {
        return  storeController.printAllItems();
    }

    public String printMostProfitableItems() {
        return storeController.printMostProfitable();
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary) throws Exception {
        return employeeController.createEmployee(employeeID, employeeName, grossSalary);
    }

    public String printEmployee(String employeeID) throws Exception {
        return employeeController.printSpecificEmployee(employeeID);
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree) throws Exception {
        return employeeController.createManager(employeeID, employeeName, grossSalary, degree);
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, int gpa) throws Exception {
        return employeeController.createIntern(employeeID, employeeName, grossSalary, gpa);
    }

    public double getNetSalary(String employeeID) throws Exception {
        return employeeController.getNetSalary(employeeID);
    }

    public String createEmployee(String employeeID, String employeeName, double grossSalary, String degree, String dept) throws Exception {
        return employeeController.createDirector(employeeID, employeeName, grossSalary, degree, dept );
    }

    public String removeEmployee(String empID) throws Exception {
        return employeeController.removeStoredEmployees(empID);
    }

    public String printAllEmployees() throws Exception {
        return employeeController.printAllEmployees();
    }

    public double getTotalNetSalary() throws Exception {
        return employeeController.getTotalNetSalary();
    }

    public String printSortedEmployees() throws Exception {
        return employeeController.printSortedEmployees();
    }

    public String updateEmployeeName(String empID, String newName) throws Exception {
        return employeeController.updateEmployeeName(empID, newName);
    }

    public String updateInternGPA(String empID, int newGPA) throws Exception {
        return employeeController.updateEmployeeGpa(empID, newGPA);
    }

    public String updateManagerDegree(String empID, String newDegree) throws Exception {
        return employeeController.updateEmployeeDegree(empID, newDegree);
    }

    public String updateDirectorDept(String empID, String newDepartment) throws Exception {
        return employeeController.updateEmployeeDepartment(empID, newDepartment);
    }

    public String updateGrossSalary(String empID, double newSalary) throws Exception {
        return employeeController.updateEmployeeInitialGrossSalary(empID, newSalary);
    }

    public Map<String, Integer> mapEachDegree() throws Exception {
        return employeeController.getNumberOfEmployeesPerDegree();
    }

    public String promoteToManager(String empID, String degree) throws Exception {
        return employeeController.promoteToManager(empID, degree);

    }

    public String promoteToDirector(String empID, String degree, String department) throws Exception {
        return employeeController.promoteToDirector(empID, degree, department);
    }

    public String promoteToIntern(String empID, int gpa) throws Exception {
        return employeeController.promoteToIntern(empID, gpa);
    }
}
