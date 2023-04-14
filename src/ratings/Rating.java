package ratings;

public class Rating {
    private String reviewerID;
    private int rating;

    public Rating(String reviewerID, int reviewerRating) {
        this.reviewerID = reviewerID;
        setRating(reviewerRating);
    }

    public String getReviewerID() {
        return reviewerID;
    }

    public void setReviewerID(String reviewerID) {
        this.reviewerID = reviewerID;
    }

    public int getRating(){return rating;}

    public void setRating(int reviewerRating) {
        if(1 <= reviewerRating && reviewerRating <= 5){
            this.rating = reviewerRating;
        } else { this.rating = -1;}
    }
}
