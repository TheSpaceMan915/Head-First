package Tests.Collections;

import java.util.Comparator;

public class SongComparator implements Comparator<Song> {
    @Override
    public int compare(Song s1, Song s2) {
        int res = 0;
        if (s1.getDuration() > s2.getDuration()) res = 1;
        else if (s1.getDuration() < s2.getDuration()) res = -1;

        return res;
    }
}
