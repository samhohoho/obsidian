---
id: abstract
aliases: []
tags: []
---

Some classes just should NOT be instantiated.
What the fork is animal?
What are the specification? (shape, color, size)
```java
Animal animal = new Animal();
```

Marking the class as `abstract`, the compiler stop creating an instance of that type.
Use it as a polymorphic array.

An `abstract class` has virtually no use, no value, no purpose in life, unless it is extended.

An `abstract class` can have static members.

You cannot make a new instance of an abstract type, but you can make an array object.
```java
private Animal[] animals = new Animal[5];
```

# Abstract method
An abstract class must be **extended**.
An abstract method must be **overridden**.

You cant think of any generic method implementation that could be useful for subclasses.

**An abstract method has no body.**

**The class must be abstract as well.**
But you can mix both abstract and non-abstract methods in the abstract class.

Which is good because all subtypes have this method.

**Either sub-abstract-class or subclass must implement all abstract methods.**
