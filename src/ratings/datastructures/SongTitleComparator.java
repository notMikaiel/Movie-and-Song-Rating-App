package ratings.datastructures;

import ratings.Song;

public class SongTitleComparator extends Comparator<Song>{

    public boolean compare(Song a, Song b) {
        int retval = a.getTitle().compareToIgnoreCase(b.getTitle());
        return retval < 0;
    }

}