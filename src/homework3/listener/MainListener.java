package homework3.listener;

import java.util.ArrayList;
import java.util.List;

public class MainListener {
    public static void main(String[] args) {
        Song song1 = new Song("title1", "artist1");
        Song song2 = new Song("title2", "artist2");
        Song song3 = new Song("title3", "artist3");
        Song song4 = new Song("title4", "artist4");
        Song song5 = new Song("title5", "artist5");
        Song song6 = new Song("title6", "artist6");
        Song song7 = new Song("title7", "artist7");
        Song song8 = new Song("title8", "artist8");
        Song song9 = new Song("title9", "artist9");

        List<Song> likedSongs1 = new ArrayList<>();
        likedSongs1.add(song1); likedSongs1.add(song2); likedSongs1.add(song3);
        likedSongs1.add(song8); likedSongs1.add(song9);

        List<Song> likedSongs2 = new ArrayList<>();
        likedSongs2.add(song5); likedSongs2.add(song6); likedSongs2.add(song1);
        likedSongs2.add(song2); likedSongs2.add(song3);likedSongs2.add(song8);

        List<Song> likedSongs3 = new ArrayList<>();
        likedSongs3.add(song1); likedSongs3.add(song2); likedSongs3.add(song3);
        likedSongs3.add(song4);

        List<Song> likedSongs4 = new ArrayList<>();
        likedSongs4.add(song4); likedSongs4.add(song5); likedSongs4.add(song6);
        likedSongs4.add(song1); likedSongs4.add(song2);

        List<Listener> listenerList = new ArrayList<>();
        listenerList.add(new Listener("Cаша", likedSongs1));
        listenerList.add(new Listener("Аня", likedSongs2));
        listenerList.add(new Listener("Маша", likedSongs3));
        listenerList.add(new Listener("Даня", likedSongs4));

        //ожидаемый результат Аня и Даня имеют схожие вкусы, Саша и Аня имеют схожие вкусы
        //в обратную сторону не работает (например Аня Саша) так как у Ани больше песен, процент совпадения меньше

        listenerList.forEach(currentListener -> {
            currentListener.getRecommendations(listenerList);
        });

    }


}
