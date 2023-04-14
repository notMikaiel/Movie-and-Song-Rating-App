package ratings;

import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;

public class Movie extends Ratable{
    private String title;
    private ArrayList<String> cast;
    public Movie(String title, ArrayList<String> cast) {
        this.title = title;
        this.cast = cast;
    }
    public ArrayList<String> getCast() {
        return cast;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", cast=" + cast +
                '}';
    }
}
