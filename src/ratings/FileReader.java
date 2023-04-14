package ratings;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader {
    public static ArrayList readSongs (String filename){
        try {
            ArrayList<Song> retval = new ArrayList<>();
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for(String line: lines){
                // 4XHclqTmhqIDMmdeMGbRVK,Dance Mix,Happy Birthday,519,4
                // "songID,artist,title,reviewerID,rating"
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));

                String songID = splits.get(0);
                String artist = splits.get(1);
                String title = splits.get(2);
                String reviewerID = splits.get(3);
                Rating rating = new Rating(reviewerID, Integer.parseInt(splits.get(4)));

                Song song = new Song(title, artist, songID);
                song.addRating(rating);
                if(!retval.contains(song)){
                    retval.add(song);
                }
            }
            return retval;
        }catch (IOException exception){
            return new ArrayList();
        }
    }
    public static ArrayList readMovies (String filename){
        try {
            ArrayList<Movie> retval = new ArrayList<>();
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            for(String line: lines){
                //"movieTitle,castMember0,castMember1,castMember2,etc"
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));

                ArrayList<String> cast = new ArrayList<>();
                for(int i = 1; i < splits.size(); i++) {
                   cast.add(splits.get(i));
                }
                Movie movie = new Movie(splits.get(0),cast);
                retval.add(movie);
            }


            return retval;

        }catch (IOException exception){
            return new ArrayList<>();
        }
    }
}