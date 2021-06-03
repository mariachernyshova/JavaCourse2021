package homework3.listener;

import java.util.ArrayList;
import java.util.List;

public class Listener {

    private String name;
    private List<Song> likedSongs = new ArrayList<>();

    public Listener(String name) {
        this.name = name;
    }

    public Listener(String name, List<Song> likedSongs) {
        this.name = name;
        this.likedSongs = likedSongs;
    }

    public String getName() {
        return name;
    }

    public List<Song> getLikedSongs() {
        return likedSongs;
    }

    public void getRecommendations(List<Listener> listenerList) {
        //рекомендовать песни, которых нет у this
        for (Listener listener : listenerList) {
            if (!this.equals(listener)) {
                if (this.checkLikedSongs(listener)) {
                    System.out.printf("%s, %s - схожие вкусы\nРекомендации: ", this.name, listener.name);
                    listener.likedSongs.forEach(song -> {
                        if (!this.likedSongs.contains(song)) {
                            System.out.printf(" %s;", song.toString());
                        }
                    });
                    System.out.printf("\n\n");
                } else {
                    System.out.printf("%s, %s - вкусы различаются\n\n", this.name, listener.name);
                }
            }
        }
    }

    public boolean checkLikedSongs(Listener listener ) {
        int count = 0;
        for (Song song : this.likedSongs) {
            if (listener.likedSongs.contains(song)) count++;
        }

        //true, если вкусы похожи (больше = 80%совпадений
        return count*100/this.likedSongs.size() >= 80;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", name, likedSongs.toString());
    }
}
