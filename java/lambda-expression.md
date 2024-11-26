---
id: lambda-expression
aliases: []
tags: []
---
https://dev.java/learn/lambdas/first-lambdas/

# Type of a lambda expression
- Type must be a functional interface.
- [[interface#Functional interface|Functional interface]] is an interface with only one **abstract** method.

# Implementing the right method.
- Lambda expression is an implementation of the abstract method.
```
// Functional interface
public interface Predicate<T> {
    boolean test(T t);
}

// Using lambda expression
Predicate<String> predicate = 
    (String s) -> {
        return s.length() == 3;
    }
```
## Implementing a `Runnable`
```java
Runnable runnable = () -> System.out.println("I am running");
```
