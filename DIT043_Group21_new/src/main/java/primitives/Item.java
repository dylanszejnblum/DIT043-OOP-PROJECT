package primitives;

import helpers.MathHelpers;

import java.util.ArrayList;

public class Item {
    public String name;
    public double price;
    public String ID;
    public ArrayList<Review> Reviews;
    public Item(String  ID,String name, double price) {
        if(name!=null || ID!=null|| price > 0){
            this.name = name;
            this.price = price; // do we really need to truncate :)
            this.ID = ID;
        }
        throw new IllegalArgumentException("Invalid data for item");
    }

    public String GetName(){
        return this.name;
    }




    public String getId(){
        return this.ID;
    }
    public Double GetPrice(){
        return this.price;
    }

    public void UpdatePrice(double NewPrice){
        this.price = NewPrice;
    }
    public void UpdateName(String NewName){
        this.name = NewName;
    }

    // Add to string method to the rest of the classes
    public String toString(){
       return  this.ID + ": " + this.name+" ." + String.valueOf(this.price);
    }

    public void CreateReview(int grade , String writtenReview){
        Review NewReview = new Review(this.ID, grade , writtenReview);
        Reviews.add(NewReview);
    }

    public double GetMeanReview(){
         double avg; double sum=0;
        for(int i = 0; i < Reviews.size(); i++) {
            Review n = Reviews.get(i);
            sum = sum + Double.valueOf(n.GetGrade());
        }
        // find the average value
        avg = sum / Reviews.size();


        return MathHelpers.TruncateDouble(avg,2);
    }


    public String PrintAllWrittenReviews() {

        String AllReviews = "";
        for (Review review : Reviews) {
            AllReviews = review.GetWrittenReview() + "\n ";
        }
        return AllReviews;
    }



    public String printAllReviews(){

        String AllReviews = "";
        for(Review review:Reviews){
            AllReviews = review.printItem() + "\n ";
        }
        return AllReviews;
    }


}
