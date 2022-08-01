package Tests.Collections;
import java.util.*;


public class DriveCollections {

    public static void countNumbers(List<? extends Number> list)
    { list.forEach(number -> System.out.println(number)); }


    public static void main(String[] args)
    {
        SongComparator comparator = new SongComparator();
        Song song1 = new Song(1.23,"Fade Away");
        Song song2 = new Song(4.32,"Angel");
        Song song3 = new Song(2.12,"Back in Black");
        Song song4 = new Song(1.54,"Don't look back in anger");
        Song song_copy = new Song(1.54,"Don't look back in anger");

       /*
       List<Song> list_songs = new ArrayList<>();

        list_songs.add(song1);
        list_songs.add(song2);
        list_songs.add(song3);

        Collections.sort(list_songs,comparator);
        System.out.println(list_songs);


        boolean test1 = song_copy.equals(song4);
        boolean test2 = song4.equals(song_copy);
        System.out.println(test1);
        System.out.println(test2);
        int hash_code = song_copy.hashCode();
        System.out.println("Hash code song_copy: " + hash_code);
        int hash_code2 = song4.hashCode();
        System.out.println("Hash code song4: " + hash_code2);
        */

        Map<String,Integer> map_salaries = new HashMap<>();
        map_salaries.put("Dave",32452);
        map_salaries.put("John",73234);
        map_salaries.put("Sara",43233);
        System.out.println(map_salaries);


        Number[] arr_numbers = {32.4,53,21.3};
        Integer[] arr_ints = new Integer[3];
        List<Integer> list_ints = new ArrayList<>();
        list_ints.add(3);
        list_ints.add(453);
        list_ints.add(70);
        countNumbers(list_ints);

    }
}
