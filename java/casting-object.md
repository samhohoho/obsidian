---
id: casting-object
aliases: []
tags: []
---

```java
Object o = al.get(index);
Dog d = (Dog) o; // cast the Object back to a Dog
d.roam();
```

If you are unsure its a `Dog`, you can use `instanceof` operator to check.
If you are wrong, you will get a `ClassCastException` at runtime.
```java
if (o instanceof Dog) {
    Dog d = (Dog) o;
}
```

