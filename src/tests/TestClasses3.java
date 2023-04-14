package tests;

import org.junit.Test;
import ratings.FileReader;
import ratings.Movie;
import ratings.Rating;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestClasses3 {

    @Test
    public void rating_csv_does_not_exist(){
        String filename = "data/does_not_exist.csv";
        ArrayList<Rating> actual = FileReader.readSongs(filename);
        ArrayList<Rating> expected = new ArrayList<>();
        assertTrue(actual.equals(expected));
    }
//    @Test
//    public void rating_test_ID(){
//        String filename = "data/movies_one_entry.csv";
//
//
//        assertTrue(actual.equals(expected));
//    }

}
