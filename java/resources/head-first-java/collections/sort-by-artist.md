---
id: sort-by-artist
aliases: []
tags: []
---

[[sort|sorted]], [[comparable-class|comparable class]]

```java
public class Jukebox1 {
    ArrayList<String> songList = new ArrayList<String>();
    public static void main(String[] args) {
        new Jukebox1().go();
    }

    // creating custom comparator using comparable class
    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Sont two) {
            return one.getArtist().compareTo(two.getArtist());
        }
    }

    public void go() {
        getSongs();

        // using custom comparator to sort by artist
        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList, artistCompare);

        // using hashSet instead to prevent duplicates
        HashSet<song> songSet = new HashSet<Song>();
        songSet.addAll(songList);

        // call the no-arg TreeSet constructor
        // to stay sorted and prevent duplicates
        TreeSet<Song> songSet = new TreeSet<Song>();
        songSet.addAll(songList);

        // call the overloaded TreeSet constructor
        ArtistCompare artistCompare = new ArtistCompare();
        TreeSet<Song> songSet = new TreeSet<Song>(artistCompare);

        System.out.println(songList);
    }

    void getSongs() {
        try {
            File file = new File(“SongList.txt”);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line= reader.readLine()) != null) {
                addSong(line);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split(“/”);
        songList.add(tokens[0]);
    }
}
```
