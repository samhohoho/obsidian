---
id: list-interface
aliases:
  - List
tags: []
---

https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html

```java
public interface List<E> extends Collection<E>  
```

**when sequence matters.**

**knows about index position.**
You can have more than one element referencing the same object.

Inherits Collection interface.
Maintan ordered collection.
Random access.
    Constant time indexed element access.
Allowed duplicate elements.
Allowed null elements.
Implements [[ArrayList]] and [[LinkedList]].
