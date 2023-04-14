package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {
    private String title;

    private LinkedListNode<Rating> listOfRatings;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public double averageRating() {
        double sum = 0.0;
        double count = 0;

        LinkedListNode<Rating> node = listOfRatings.getNext();
        while (node != null) {
            if (node.getValue().getRating() != -1) {
                sum += node.getValue().getRating();
                count += 1;
            }
            node = node.getNext();
        }
        if (count > 0){return sum/count;} else {return 0;}
    }

    public void removeRatingByReviewer(Reviewer reviewer) {
        LinkedListNode<Rating> node = listOfRatings;
        while (node.getNext() != null) {
            if (node.getNext().getValue().getReviewerID().equals(reviewer.getReviewerID())) {
                node.setNext(node.getNext().getNext());
                return;
            }
            node = node.getNext();
        }
    }

    public Boolean didReviewerRateSong(String reviewerID) {
        LinkedListNode<Rating> node = listOfRatings.getNext();
        while (node != null) {
            if (node.getValue().getReviewerID().equals(reviewerID)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public void addRating(Rating newRating){
        if (this.listOfRatings == null){
            this.listOfRatings = new LinkedListNode<Rating>(newRating,null);
        } else if (!didReviewerRateSong(newRating.getReviewerID())) {
            listOfRatings.append(newRating);
        }
    }
    public LinkedListNode<Rating> getRatings(){return listOfRatings;}
    public double bayesianAverageRating(int extraRating, int value ) {
            double sum = 0.0;
            double count = 0;

            LinkedListNode<Rating> node = listOfRatings;
            while (node != null) {
                if (node.getValue().getRating() != -1) {
                    sum += node.getValue().getRating();
                    count += 1;
                }
                node = node.getNext();
            }
            count += extraRating;
            sum += (extraRating * value);

            if (count > 0) {return sum / count;} else {return 0.0;}
        }
}