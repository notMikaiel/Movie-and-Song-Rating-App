
package ratings;
public class Reviewer {
    private String reviewerID;

    public Reviewer(String reviewerID) {
        this.reviewerID = reviewerID;
    }

    public String getReviewerID() {
        return reviewerID;
    }

    public void setReviewerID(String ID) {
        reviewerID = ID;
    }


    public Rating rateSong(int rating) {
        Rating retval = new Rating(getReviewerID(), rating);
        return retval;
    }
}
