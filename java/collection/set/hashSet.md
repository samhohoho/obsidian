---
id: hashSet
aliases: []
tags: []
---
```java
HashSet<T> set=new HashSet<T>(); 
```

```java
HashSet() // default HashSet
HashSet(int capacity)
HashSet(int capacity, float loadFactor)
HashSet(Collection<? extends E> c) // initialize using collection c element
```

Inherits `AbstractSet` class and implement [[Set]] interface.
Uses hash table for storage.
Unique elements only.
Allows null value.
Non-synchronized.
Inserted based on `hashcode` instead of insertion order.
Default capacity is 16, load factor 0.75.

# How a HashSet checks for duplicates: hashCode() and equals()
It uses the object's hashcode value to determine where to put the object in the Set.
But also compares the object's hashcode to the hashcode of all the other objects in the HashSet.

**Your hashcodes are the same, but are you REALLY equal?**
HashSet finds a matching hashcode, it will then call one of the object's `equals()` methods to see if are equal.
