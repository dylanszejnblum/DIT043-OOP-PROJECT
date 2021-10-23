package primitives;

public class Review {
    public String ID;
    public int grade;
    public String writtenReview;
    public boolean hasComment;
    public Review (String ID , String writtenReview , int grade ){
        if(grade <1 || grade >5){
            throw new IllegalArgumentException("Grade values must be between 1 and 5");
        } else {
            this.ID = ID;
            this.grade = grade;
            this.writtenReview = writtenReview;
        }
    }


    public Review (String ID , int grade){
        if(grade <1 || grade >5){
            throw new IllegalArgumentException("Grade values must be between 1 and 5");
        } else {
            this.ID = ID;
            this.grade = grade;
            this.writtenReview = " ";
        }

    }

    public String getWrittenReview() {
        return this.writtenReview;
    }

    public int getGrade(){
        return this.grade;
    }




    public String reviewToString(){

        return "Grade: "+this.getGrade()+"." + getWrittenReview();

    }


    public String printItem(){
        return "Grade: "+ this.grade + " " + this.writtenReview;
    }
}
