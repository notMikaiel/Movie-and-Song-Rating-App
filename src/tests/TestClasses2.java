package tests;

import org.junit.Test;
import ratings.Movie;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;
import ratings.datastructures.Comparator;

import java.util.ArrayList;


import static org.junit.Assert.assertTrue;

public class TestClasses2 {
    private final double EPSILON = 0.001;

    public void compareDoubles(double d1, double d2) {
        assertTrue(d1 + " and " + d2 + " are not within " + EPSILON, Math.abs(d1 - d2) < EPSILON);

    }
    @Test
    public void songBayesianAverageRatingWithExtraRatings(){
        Song song = new Song("WAIT FOR U", "Future", "101");
        song.addRating(new Rating("1", 4));
        song.addRating(new Rating("2", 5));
        double average = song.bayesianAverageRating(2, 3);
        compareDoubles(average,3.75);
    }
    @Test
    public void songBayesianAverageRatingWithNoRatings(){
        Song song = new Song("Never gonna give you up", "Rick Astley", "2009");
        double average = song.bayesianAverageRating(0, 0);
        compareDoubles(average,0.0);
    }
    @Test
    public void songBayesianComparatorAddsNoRatings(){
        Song song1 = new Song("Never gonna give you up", "Rick Astley", "2009");
        song1.addRating(new Rating("1", 4));
        song1.addRating(new Rating("2", 4));

        Song song2 = new Song("WAIT FOR U", "Future", "101");
        song2.addRating(new Rating("3", 4));

        SongBayesianRatingComparator comparator = new SongBayesianRatingComparator();
        assertTrue(comparator.compare(song1,song2));
    }


    @Test
    public void getMovieTitle(){
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        Movie catMovie = new Movie("tomAndJerry", cast);

        assertTrue(catMovie.getTitle().equals("tomAndJerry"));

    }
    public boolean compareArrayListsIgnoreCase(ArrayList<String> x, ArrayList<String> y) {
        for (int i = 0; i < x.size(); i++) {
            String str1 = x.get(i);
            String str2 = y.get(i);
            if (!str1.equalsIgnoreCase(str2)) {
                return(false);
            }
        }
        return(true);
    }
    @Test
    public void movieGetCast(){
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        ArrayList<String> test1 = new ArrayList<String>();
        test1.add("Chris Pratt");
        test1.add("Zoe Saldana");
        test1.add("Dave Bautista");

        ArrayList<String> test2 = new ArrayList<String>();
        test2.add("chris pratt");
        test2.add("zoe saldana");
        test2.add("dave bautista");

        ArrayList<String> test3 = new ArrayList<String>();
        test3.add("CHRIS pratt");
        test3.add("ZoE SalDANA");
        test3.add("dAVE bautistA");


        Movie catMovie = new Movie("tomAndJerry", cast);

        assertTrue(compareArrayListsIgnoreCase(catMovie.getCast(), test1));
        assertTrue(compareArrayListsIgnoreCase(catMovie.getCast(), test2));
        assertTrue(compareArrayListsIgnoreCase(catMovie.getCast(), test3));
    }

    @Test
    public void movieBayesianAverageRatingWithExtraRatings(){
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        Movie catMovie = new Movie("tomAndJerry", cast);
        catMovie.addRating(new Rating("1", 4));
        catMovie.addRating(new Rating("2", 5));
        double average = catMovie.bayesianAverageRating(2, 3);
        compareDoubles(average,3.75);
    }
    @Test
    public void movieBayesianAverageRatingWithNoRatings(){
        ArrayList<String> cast = new ArrayList<String>();
        cast.add("Chris Pratt");
        cast.add("Zoe Saldana");
        cast.add("Dave Bautista");

        Movie catMovie = new Movie("tomAndJerry", cast);
        double average = catMovie.bayesianAverageRating(0, 0);
        compareDoubles(average,0.0);
    }
    @Test
    public void testSongCompare(){
        SongTitleComparator comparator = new SongTitleComparator();
        Song aSong = new Song("A song", "A artist", "AAA1");
        Song bSong = new Song("a song", "b artist", "aaa1");
        Song BSong = new Song("B song", "B artist", "BBB1");
        Song BBSong = new Song("b song", "B artist", "BBB1");

        assertTrue(comparator.compare(aSong,bSong) == false);
        assertTrue(comparator.compare(aSong,BSong) == true);
        assertTrue(comparator.compare(aSong,BBSong) == true);
        assertTrue(comparator.compare(BSong,aSong) == false);
        assertTrue(comparator.compare(BSong,BBSong) == false);
    }
}

