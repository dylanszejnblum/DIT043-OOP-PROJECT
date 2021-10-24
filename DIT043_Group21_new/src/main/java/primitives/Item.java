package primitives;

import helpers.MathHelpers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private double price;
    private String ID;
    public ArrayList<Review> reviews;

    public Item(String  ID,String name, double price) {
        reviews = new ArrayList<Review>();
        this.name = name;
        this.price = price; // do we really need to truncate :)
        this.ID = ID;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.ID;
    }
    public Double getPrice(){
        return MathHelpers.truncateDouble(this.price);
    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }
    public void setName(String newName){
        this.name = newName;
    }

    // Add to string method to the rest of the classes
    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");

        return  this.ID + ": " + this.name+". " + df.format(this.price)+ " SEK";
    }

    public String createReview(int grade , String writtenReview){
        Review NewReview = new Review(this.ID, writtenReview , grade );
        reviews.add(NewReview);

        return "plz dont break ;)";
    }



    public double getMeanReview(){
        double avg; double sum= 0; int intermediate = 0;
        if (reviews.size() == 0){
            return 0;
        }
        for(int i = 0; i < reviews.size(); i++) {
            Review n = reviews.get(i);
            sum = sum + MathHelpers.truncateDouble(n.getGrade());
        }
        // find the average value
        avg = MathHelpers.truncateDouble(sum / reviews.size());
        intermediate = (int)(avg * 10);
        avg = ((double)intermediate) /10;

        return avg;
    }


    public List<String> printAllWrittenReviews() {
        List<String> writtenReviews= new ArrayList<String>();
        if(!reviews.isEmpty()) {
            for (Review review : reviews) {
                if (review.getWrittenReview() != "") {
                    writtenReviews.add(review.getWrittenReview());
                }
            }

        }
        return writtenReviews;

    }


    public int getNumberOfReviews(){
        return reviews.size();
    }
    public String getSpecificReview(int index){

        for(int i = 0 ; i < reviews.size(); i++){
            if(index == i +1){
                return reviews.get(i).reviewToString();
            }
        }
         throw new IllegalArgumentException();
    }

    public String getAllReviwewsForItem(){
        DecimalFormat df = new DecimalFormat("0.00");
        String result = "Review(s) for "+ this.getId() +": "+this.getName()+". "+ df.format(this.getPrice())+" SEK\n";
        for(Review review: reviews){
            if(review.getWrittenReview() != " "){
                result += review.reviewToString() + "\n";
            }
        }
        return result;
    }

    public String printAllReviews(){

        String allReviews = "";
        for(Review review:reviews){
            allReviews = review.printItem() + "\n ";
        }
        return allReviews;
    }



}
