---
id: interface
aliases: []
tags: []
---
https://dev.java/learn/interfaces/defining-interfaces/
## Overview
- What?
    - interfaces are versatile reference types allowing you to define **default** methods and add functionality to a given type without breaking the implementing classes.
- Why?
    - It is important for different groups of programmers to agree to a "contract" on how their software interacts.
    - Each group should be able to write code without any knowledge of how other's code is written.
- Benefits.
    - Encapsulation.
        - To hide the details if an object's implementation.
    - Decoupling.
- Example.
    - `List` interface provides a standard contract.
        - This allows devs to work with different implementations of `List`.
        - So we are not tied down to a single implementation.
        - We can switch the implementation with minimal changes.
        Because your code depends only on the `List` interface.
- Restrictions.
    - Method bodies exist only for default, private, and static methods.
- Notes.
    - If you dont specify `public`, then the interface is accessible only to classes defined in the same package.
    - All **abstract, default, and static methods** are implicitly public.
    - Can contain constant declarations.
        - Are implicitly `public`, `static`, and `final`.
- Concrete methods.
    - Starting with Java SE 8, conrete methods are allowed.
    - They can be instance methods or static methods
    - They are called **default methods**.
- Using interface as argument instead of implementation class.
    - Promotes loose coupling and enhances flexibility in the code.
    - Decouple the code from a specific implementation.
        - Making it easier to switch implementations. Without affecting the calling code.

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
