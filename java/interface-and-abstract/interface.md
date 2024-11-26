---
id: interface
aliases: []
tags: []
---
https://dev.java/learn/lambdas/first-lambdas/

- Concrete methods.
    - Starting with Java SE 8, conrete methods are allowed.
    - They can be instance methods or static methods
    - They are called **default methods**.

## Functional interface
- They have only one **abstract** method.
    - Concrete method does not count,
```java
public interface Runnable {
    public abstract void run();
}
```
The `Runnable` interface is indeed functional, because it has one abstract method.

## Multiple inheritance

A Java interface solves your multiple inheritance problem.
The solution is to make all the methods abstract.
That way, the subclass must implement the methods.
(Abstract methods must be implemented by the first concrete subclass)

**A Java interface is like a 100% pure abstract class.**

Methods are implicitly public and abstract.

Not putting implementation turns out to be good design.
Because most interface methods would need to be overriden,
and wouldnt make sense if implemented in a generic way.

**Q: What does it have to do with polymorphism?**
