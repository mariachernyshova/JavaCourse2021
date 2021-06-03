package homework3.listener;

public class Song {

    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.artist = artist;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", title, artist);
    }
}
