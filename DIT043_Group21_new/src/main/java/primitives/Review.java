package primitives;

public class Review {
    public String ID;
    public int grade;
    public String writtenReview;

    public Review (String ID , String writtenReview , int grade ){
        if(grade <=0 || grade >5){
            throw new IllegalArgumentException("Grade values must be between 1 and 5");
        } else if(writtenReview.isEmpty()){
            writtenReview = "";
        }
        this.ID = ID;
        this.grade = grade;
        this.writtenReview = writtenReview;
    }

    public String getWrittenReview() {
        return this.writtenReview;
    }

    public int getGrade(){
        return this.grade;
    }

    public String reviewToString(){
        return "Grade: " + this.getGrade() + ". " + this.getWrittenReview();
    }


    public String printItem(){
        return "Grade: "+ this.grade + " " + this.writtenReview;
    }
}
