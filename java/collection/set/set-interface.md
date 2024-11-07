---
id: set-interface
aliases:
  - Set
tags: []
---

```java
Set<String> Set = new HashSet<String>();
Set.add("one");
Set.add("two");
```

**when uniqueness matters**

Unordered.
Duplicate item will be ignored.
Only one null value.
Implemented by [[hashSet]].

# What makes two objects equal?
For a Set to treat two objects as duplicates, you must override the `hashCode()` and `equals()` methods inherited from class `Object`.
See [[equality]].
