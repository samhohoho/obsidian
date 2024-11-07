---
id: sort
aliases: []
tags: []
---

```java
public static <T extends Comparable<? super T>> void sort(List<T> list)
```
This method can take only lists of **Comparable** objects.

`<T extends Comparable...` whatever `T` is must be of type `Comparable`.
`<? super T>` the type parameter for `Comparable` must be of type `T` or `T`'s supertypes.
`List<T>` you can pass in only a `List` that uses a parameterized type that "extends `Comparable`".
