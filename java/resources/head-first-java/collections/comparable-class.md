---
id: comparable-class
aliases: []
tags: []
---

```java
class Song implements Comparable<Song> {
    String title;
    String artist;
    String rating;
    String bpm;

    // to implement object equality for Set
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle());
    }
    public int hashCode() {
        return title.hashCode();
    }

    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    // getter setter

    public String toString() {
        return title;
    }
}
```
