package primitives;

public class Intern extends Employee{
    private int gpa;
    double grossSalary = this.initialGrossSalary;

    public Intern( final String ID, String name, double initialGrossSalary, int gpa){
        super(ID, name,initialGrossSalary) ;
        this.gpa = gpa;
        //gpa can only be between 0 and 9
    }

    public double getGrossSalary(){
        if(this.gpa <= 5){
            this.grossSalary = 0.0;
            return this.grossSalary;
        }
        else if(this.gpa < 8) {
            return this.grossSalary;
        }
        else{
            return this.grossSalary + 1000.00;
        }
    }

    public int getGpa(){return this.gpa;}
    public void setGpa(int newGpa){this.gpa = newGpa;}

    public String toString(){
        return this.getName() + " 's gross salary is " + this.getGrossSalary() + " SEK per month. GPA: " + this.getGpa();
    }

}
