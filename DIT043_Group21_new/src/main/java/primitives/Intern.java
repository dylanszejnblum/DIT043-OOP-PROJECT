package primitives;

import helpers.MathHelpers;

import java.util.ArrayList;

public class Intern extends Employee{
    private int gpa;
   // double grossSalary = this.initialGrossSalary;
    ArrayList<Review> reviewList = new ArrayList<Review>();

    public Intern( final String ID, String name, double initialGrossSalary, int gpa) throws Exception {
        super(ID, name,initialGrossSalary) ;
        if (gpa < 0 || gpa > 10){
            throw new Exception(gpa + " outside range. Must be between 0-10.");
        }
        this.gpa = gpa;
    }

    public double getInitialGrossSalary(){
        double grossSalary= this.initialGrossSalary;
        if(this.gpa <= 5){
            grossSalary = 0.0;
            return grossSalary;
        }
        else if(this.gpa > 5 && this.gpa < 8) {
            return this.initialGrossSalary;
        }
        else{
            return this.initialGrossSalary + 1000.00;
        }

    }



    public double calculateNetSalary(){
        return this.getInitialGrossSalary();
    }

    public int getGpa(){return this.gpa;}
    public void setGpa(int newGpa){this.gpa = newGpa;}

    public String toString(){
        return this.getName() + "'s gross salary is " + String.format("%.2f", calculateNetSalary()) + " SEK per month. GPA: " + this.getGpa();
    }

}
