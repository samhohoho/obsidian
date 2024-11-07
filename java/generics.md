---
id: generics
aliases: []
tags: []
---

**Generics means more type-safety.**

The main point is to let you write type-safe collections,
where more problems are caught at compile-time instead of runtime.

Without generics, objects go in as a reference to `SoccerBall` object,
and come out as a reference of type `Object`.

A generic method means that the method declaration uses a **type parameter** in its signature.

# Using generics method
You can use type parameters in a method in different ways.

## Using a type parameter defined in the class declaration
```java
public class ArrayList<E> extends AbstractList<E> ... {
    public boolean add(E o)
```
The type declared in the method argument is replaced with the type you use when you instantiate the class.
## Using a type parameter that was NOT defined in the class declaration
```java
public <T extends Animal> void takeThing(ArrayList<T> list)
```
If the class itself doesnt use a type parameter, you can still specify one for a method.

# Here's where it gets weird...
This:
```java
public <T extends Animal> void takeThing(ArrayList<T> list)
```
is NOT the same as this:
```java
public void takeThing(ArrayList<Animal> list)
```
The first one, you could invoke using an `ArrayList<Dog>`,
`ArrayList<Cat>`, or `ArrayList<Animal>`.
But, the bottom one means that only an `ArrayList<Animal>`
is legal.

# In generics, "extends" means "extends or implements"
The keyword "extends" really means "IS-A", and works for both calsses and interfaces.
```java
public static <T extends Comparable<? super T>> void sort(List<T> list
```
`<T extends Comparable...`
`Comparable` is an interface, so `T` must be a type that implements the `Comparable` interface.
It doesnt matter whether the thing on the right is a class or interface, you still say "extends".
