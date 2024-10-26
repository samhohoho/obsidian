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
