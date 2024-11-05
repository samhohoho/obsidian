---
id: inheritance
aliases: []
tags: []
---

Head First Java 2nd Edition - C7
https://www.rcsdk12.org/cms/lib/NY01001156/Centricity/Domain/4951/Head_First_Java_Second_Edition.pdf

1. Look for what the classes have in common.
2. Abstract out and put it in a new class.
3. Then link the other classes (subclasses) to this new class (superclass).

JVM walks up the inheritance tree from the invoked class untill it finds the specific version for that object.

Using IS-A and HAS-A.

**Q: What if I want use BOTH the superclass version and my overriding subclass version of a method?**
```java
public void roam() {
    super.roam();
    // my own roam stuff
}
```
This calls the inherited version of `roam()`.

# Access levels control who sees what.
The four access levels: `private`, `default`, `protected`, `public`

# Rules for overriding
- Arguments must be the same, and return types must be compatible.
- The method cant be less accessible.

**Multiple inheritance, aka Deadly Diamond if Death, can be a really bad thing.**
