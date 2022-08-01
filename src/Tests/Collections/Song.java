package Tests.Collections;

import java.util.*;

public class Song implements Comparable<Song> {

    private double m_duration;

    private String m_title;

    public Song(double duration, String title)
    {
        m_duration = duration;
        m_title = title;
    }

    public String getTitle() { return m_title; }

    public double getDuration() { return m_duration; }

    @Override
    public int compareTo(Song obj)
    { return m_title.compareTo(obj.getTitle()); }

    @Override
    public int hashCode()
    {
        int res = 1;
        res = res * 2 + m_title.hashCode();
        res = (res & 0x7fffffff) % 3;

        return res;
    }

    @Override
    public boolean equals(Object obj)
    {
        Song song_obj = null;
        if(obj instanceof Song)
        { song_obj = (Song) obj; }

        boolean res = false;

        if (m_title.equals(song_obj.getTitle()))
        {
            if (m_duration == song_obj.getDuration())
            { res = true; }
        }

        return res;
    }

    @Override
    public String toString()
    { return "title: " + m_title + ", duration: " + m_duration; }


    public static void main(String[] args)
    {

    }
}
