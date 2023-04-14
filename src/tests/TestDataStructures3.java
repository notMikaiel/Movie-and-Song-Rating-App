package tests;

import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestDataStructures3 {

//    @Test
//    public void Movie_csv_does_not_exist(){
//        String filename = "data/does_not_exist.csv";
//        ArrayList<Movie> actual = FileReader.readMovies(filename);
//        ArrayList<Movie> expected = new ArrayList<>();
//        assertTrue(actual.equals(expected));
//    }
    @Test
    public void Movie_csv_is_empty(){
        String filename = "data/movie_empty.csv";
        ArrayList<Movie> actual = FileReader.readMovies(filename);
        ArrayList<Movie> expected = new ArrayList<>();
        assertTrue(actual.equals(expected));
    }
    @Test
    public void Movie_one_cast(){
        String filename = "data/movies_one_entry.csv";
        ArrayList<Movie> actual = FileReader.readMovies(filename);

        ArrayList<String> cast = new ArrayList<>();
        cast.add("two");

        Movie expectedEntry = new Movie(null,cast);
        ArrayList<Movie> expected = new ArrayList<>();
        expected.add(expectedEntry);

        System.out.println(actual);
        System.out.println(expected);

        boolean equalLists = true;

        if (actual.size() != expected.size()) {
            equalLists = false;
        } else {
            for (int i = 0; i < actual.size(); i++) {
                if (!actual.get(i).equals(expected.get(i))) {
                    equalLists = false;
                    break;
                }
            }
        }

        assertFalse(equalLists);
    }
}
//    @Test
//    public void Movie_multiple_cast(){
//        String filename = "data/movie_empty.csv";
//        ArrayList<Movie> actual = FileReader.readMovies(filename);
//
//        String title = "Toy Story";
//
//        ArrayList<String> cast = new ArrayList<>();
//        cast.add("Tom Hanks");
//
//        Movie expectedEntry = new Movie(title,cast);
//        ArrayList<Movie> expected = new ArrayList<>();
//        assertTrue(actual.equals(expected));
//    }


