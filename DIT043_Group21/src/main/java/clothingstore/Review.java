package clothingstore;

public class Review {

    public Item item;
    private String ID;
    private int grade;
    private String writtenComment;

    public Review(String ID, int grade, String writtenComment){
        this.ID = ID;
        this.grade = grade;
        if (this.writtenComment.isEmpty()) {
            this.writtenComment = "";
        }
        else {
            this.writtenComment = writtenComment;
        }
    }

    public String getID(){
        return this.ID;
    }
    public void setID(String newID) {
        this.setID(newID);
    }
    public int getGrade(){
        return this.grade;
    }
    public void setGrade(int newGrade) {
        this.grade = newGrade;
    }
    public String getWrittenComment(){
        return this.writtenComment;
    }
    public void setWrittenComment(String newWrittenComment){
        this.writtenComment = newWrittenComment;
    }

    //Is the opinion really optional??
    public String createReview(String ID, int grade, String writtenComment){
        Review review = new Review(ID, grade, writtenComment);
        item.reviewList.add(review);
        return "";
    }

}
