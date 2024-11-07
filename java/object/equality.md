---
id: equality
aliases: []
tags: []
---

# Reference equality
Two references that refer to the same object on the heap are equal.
Calling `hashCode()` method on both references will get the same result.

Java assign a hashcode based on the object's memory address on the heap.
So no two objects will have the same hashcode.

To check if two references are referring to the same object:
```java
foo == bar
```
# Object equality
Two references, two objects on the heap, but the objects are considered meaningfully equaivalent.

If you want to treat two different `Song` objects as equal (matching title variables), you must override both the `hashCode()` and `equals()` methods inherited from class `Object`.
```java
public boolean equals(Object aSong) {
    Song s = (Song) aSong;
    return getTitle().equals(s.getTitle());
}
public int hashCode() {
    return title.hashCode();
}
```
Title is a String and has an overriden `equals()` method.
String has an overriden `hashCode()` method and return the hashCode result on title.

# Java Object Law
- If two objects are equal, they MUST have matching hashcodes.
- If two objects are equal, calling `equals()` on either object MUST return true.
- If two objects have the same hashcode value, they are NOT required to be equal.
But if they are equal. they MUST have the same hashcode value.
- So, if you override `equals()`, you MUST override `hashCode()`.
- `hashCode()` is to generate a unique integer for each object on the heap.
So if you dont override `hashCode()`, no two objects of that type can EVER be considered equal.
- The default behavior of `equals()` is to do an `==` comparison.
`a.equals(b)` must also mean that
`a.hashCode() == b.hashCode()`.
But `a.hashCode() == b.hashCode()`
does NOT have to mean `a.equals(b)`.

**Q: How come hashcodes can be the same even if objects arent equal?**
HashSet uses hashcodes to store the elements in a way that makes it much faster to access. It uses hashcode as a kind of label on the "bucket" where it stored the element. So, it gets the hashcode value from the copy of the given object and find it.

The hashcodes can be the same without necessarily guaranteeing that the objects are equal, because the "hashing algorithm" used in the `hashCode()` might return the same value for multiple objects. And yes, multiple objects would all land in the same bucket in the HashSet.

But if the hashSet finds more than one object in the same hashcode bucket, it will use the `equals()` to see if its a perfect match. Hashcodes are sometimes used to narrow down the search, but to find the exact match, the HashSet still has to take all objects in that one bucket and then call `equals()` on them.
