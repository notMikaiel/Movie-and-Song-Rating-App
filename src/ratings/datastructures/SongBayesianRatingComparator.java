package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator extends Comparator<Song> {

    public boolean compare(Song a, Song b) {
        return (a.bayesianAverageRating(2,3) > b.bayesianAverageRating(2,3));
    }

}