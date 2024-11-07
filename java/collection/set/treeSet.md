---
id: treeSet
aliases: []
tags: []
---

Inherits `AbstractSet` class and implement [[Set]] interface.
Keeps the elements sorted and prevent duplicates.

The downside to TreeSet is that if you dont need sorting, you are still paying for it with a small performance hit.

# Calling the no-arg TreeSet.
```java
TreeSet<Song> songSet = new TreeSet<Song>();
```

**TreeSet elements MUST be comparable**
You have to tell the TreeSet how the objects should be sorted.
```java
class Book implements comparable {
    String title;
    public Book(String t) {
        title t;
    }
    public int compareTo(Object b) {
        Book book = (book) b;
        return (title.compareTo(book.title));
    }
}
```

TreeSet's sole purpose in life is to keep your elements sorted,
and it had no idea how to sort `Book` objects.

It doesnt fail at compile-time.
TreeSet `add()` doesnt take a `Comparable` type.
But it fails at runtime when you add the second element to the set.

# You use the TreeSet's overloaded constructor that takes a Comparator
TreeSet works a lot like `sort()`.
Using a custom `Comparator`.
```java
public class BookCompare implements Comparator<Book> {
    public int compare(Book one, Book two) {
        return (one.title.compareTo(two.title));
    }
}
class Test {
    BookCompare bCompare = new BookCompare();
    TreeSet<Book> tree = new TreeSet<Book>(bCompare);
}
```
