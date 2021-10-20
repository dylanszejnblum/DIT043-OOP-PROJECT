package primitives;

public class Review {
    public String ID;
    public int grade;
    public String WrittenReview;

    public Review (String ID , int grade , String WrittenReview){
        if(grade <=0 || grade >5){
            throw new IllegalArgumentException("Grade values must be between 1 and 5");
        } else if(WrittenReview == null){
            WrittenReview = " ";
        }
        this.ID = ID;
        this.grade = grade;
        this.WrittenReview = WrittenReview;
    }

    public String GetWrittenReview() {
        return this.WrittenReview;
    }

    public int GetGrade(){
        return this.grade;
    }


    public String printItem(){
        return "Grade: "+ this.grade + " " + this.WrittenReview;
    }





}
