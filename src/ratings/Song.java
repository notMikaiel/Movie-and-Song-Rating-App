package ratings;


import ratings.datastructures.LinkedListNode;

public class Song extends Ratable{
        private String artist;
        private String songID ;

    public Song(String title, String artist, String songID) {
        this.setTitle(title);
        this.setArtist(artist);
        this.setSongID(songID);
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getSongID () {
        return songID;
    }
    public void setSongID (String ID) {
        this.songID = ID;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "artist='" + artist + '\'' +
//                ", songID='" + songID + '\'' +
//                '}';
//    }
}
