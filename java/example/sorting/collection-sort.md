---
id: collection-sort
aliases: []
tags: []
---

```java
public class SortMountains {
    LinkedList<Mountain> mountains = new LinkedList<Mountain>();
    class NameCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return one.name.compare(two.name);
        }
    }
    class HeightCompare implements Comparator<Mountain> {
        public int compare(Mountain one, Mountain two) {
            return two.height - one.height;
        }
    }
    public static void main(String[] args) {
        new SortMountains().go();
    }
    public void go() {
        mountains.add(new Mountain("Longs", 1333));
        mountains.add(new Mountain("Longs", 1332));
        mountains.add(new Mountain("Longs", 1331));

        NameCompare nameCompare = new NameCompare();
        Collections.sort(mountains, NameCompare);

        HeightCompare heightCompare = new HeightCompare();
        Collections.sort(mountains, heightCompare);
    }
}
```
```java
class Mountain {
    String name;
    int height;

    Mountain(String n, int h) {
        name = n;
        height = h;
    }

    public String toString() {
        return name + " " + height;
    }
}
```
