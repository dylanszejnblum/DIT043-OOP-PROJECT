package primitives;

import helpers.MathHelpers;

import java.util.ArrayList;

public class Item {
    public String name;
    public double price;
    public String ID;
    public ArrayList<Review> reviews;
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
    public Double getPrice(){
        return this.price;
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    public void setName(String newName){
        this.name = newName;
    }

    // Add to string method to the rest of the classes
    public String toString(){
       return  this.ID + ": " + this.name+" ." + String.valueOf(this.price);
    }

    public void createReview(int grade , String writtenReview){
        Review NewReview = new Review(this.ID, grade , writtenReview);
        reviews.add(NewReview);
    }

    public double getMeanReview(){
         double avg; double sum=0;
        for(int i = 0; i < reviews.size(); i++) {
            Review n = reviews.get(i);
            sum = sum + Double.valueOf(n.getGrade());
        }
        // find the average value
        avg = sum / reviews.size();
        return MathHelpers.truncateDouble(avg);
    }


    public String printAllWrittenReviews() {

        String allReviews = "";
        for (Review review : reviews) {
            allReviews = review.getWrittenReview() + "\n ";
        }
        return allReviews;
    }


    public String getSpecificReview(int index){

        for(int i = 0 ; i < reviews.size(); i++){
            if(index == i){
                return reviews.get(i).toString();
            }
        }
         throw new IllegalArgumentException();
    }

    public String printAllReviews(){

        String allReviews = "";
        for(Review review:reviews){
            allReviews = review.printItem() + "\n ";
        }
        return allReviews;
    }


}
