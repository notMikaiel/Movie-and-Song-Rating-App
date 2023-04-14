package tests;

import org.junit.Test;
import ratings.Playlist;
import ratings.Song;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongTitleComparator;
import ratings.datastructures.SongBayesianRatingComparator;


import static org.junit.Assert.assertTrue;

public class TestDataStructures2 {

    @Test
    public void testAddSong(){
        Song song = new Song("WAIT FOR U", "Future", "101");
        SongTitleComparator comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);
        playlist.addSong(song);
        assertTrue(playlist.getSongList().getValue().getTitle().equals("WAIT FOR U"));
    }

    @Test
    public void testGetSongList(){
        Song song1 = new Song("A - WAIT FOR U", "Future", "101");
        Song song2 = new Song("B - I", "Kendrick", "5000");
        Song song3 = new Song("C - 90210", "Travis Scott", "90210");
        Song song4 = new Song("D - lolsmh", "westSideBoogie", "90210");

        SongTitleComparator comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);
        playlist.addSong(song1);
        playlist.addSong(song3);
        playlist.addSong(song2);
        playlist.addSong(song4);

        LinkedListNode<Song> sorted = new LinkedListNode(song4,null);
        sorted = new LinkedListNode(song3, sorted);
        sorted = new LinkedListNode(song2, sorted);
        sorted = new LinkedListNode(song1, sorted);

        assertTrue(sorted.toString().equals(playlist.getSongList().toString()));
    }
    @Test
    public void testEmptyPlaylist(){
        SongTitleComparator comparator = new SongTitleComparator();
        Playlist playlist = new Playlist(comparator);
        assertTrue(playlist.getSongList() == null);
    }
}
