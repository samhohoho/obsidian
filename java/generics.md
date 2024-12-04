---
id: generics
aliases: []
tags: []
---
# Overview
- What?
    - Parameterized types (classes and interfaces).
    - Enable types to be parameters when defining classes, interfaces, and methods.
- Why?
    - To re-use the same code with different inputs.
    - To write type-safe collections.
    - More type-safety.
    - Stronger type checks at compile time.
    Problems can be caught at compile-time instead of runtime.
- Notes:
    - `T` in `Foo<T>` is a type parameter.
    - `String` in `Foo<String> f` is a type argument. 
## Elimination of casts.
```java
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
```
```java
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast
```
- Features:
    - To implement generic algorithms.
# Generic types
A generic type is a generic class/interface that is parameterized over types.
## Without generic
```java
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```
- Problems.
    - You are free to pass in whatever you want (except primitive types).
    - There is no way to verify, at compile-time, how the class is used.
    - One part of the code may expect to get objects of type `Integer`.
    The other part may pass n a `String`, resulting in a runtime error.
## With generic
```java
class name<T1, T2, ..., Tn> { /* ... */ }
```
```java
/**
 * Generic version of the Box class.
 * @param <T> the type of the value being boxed
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```
## Type parameter naming convention
E - Element (used by Java collections frameworks)
K - Key
N - Number
T - Type
V - Value
## The Diamond `<>`
- What?
    - With an empty set of type arguments,
    the compiler can determince/infer the type arguments from the context.
```java
OrderedPair<String, Integer> p1 = new OrderedPair<>("Even", 8);
OrderedPair<String, String>  p2 = new OrderedPair<>("hello", "world");
```
## Multiple Type Parameters
```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

public class OrderedPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
    this.key = key;
    this.value = value;
    }

    public K getKey()    { return key; }
    public V getValue() { return value; }
}

Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
```
====
<!-- where more problems are caught at compile-time instead of runtime. -->

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
## What could happen if it were allowed...
If you passed a Dog ArrayList to the 2nd method, then suddenly you add a Cat in the Dog list. The compiler knows that if it lets you pass a Dog ArrayList into the method like that, someone could, at runtime, add a Cat to your Dog list.
So intead, the compiler just wont let you take the risk.
## Array types are checked again at runtime, but collection type checks happen only when you compile
```java
public void go() {
    Dog[] dogs = {new Dog(), new Dog()};
    takeAnimals(dogs);
}
public void takeAnimals(Animal[] animals) {
    animals[0] = new Cat(); // ArrayStoreException
}
```
## Wildcards to the rescue
There is a way to create a method argument that can accept an ArrayList of any Animal subtype.
```java
public void takeAnimals(ArrayList<? extends Animal> animals) {
    for(Animal a: animals) {
        a.eat();
    }
}
```
The keyword `extends` means either extends or implements.

When you use the wildcard `<?>` in your declaration, the compiler wont let you add new things to the list.
So you are safe at runtime.

This is OK:
```java
for(Animal a: animals) {
    a.eat();
}
```
But this would not compile:
```java
animals.add(new Cat());
```
### Alternate syntax
This:
```java
public <T extends Animal> void takeThing(ArrayList<T> list)
```
Does the same as this:
```java
public void takeThing(ArrayList<? extends Animal> list)
```
**Q: Why would you use one over the other?**
Depends on where you want to use `T`.
If you want the method to have two arguments--both of which are lists of a type that extend `Animal`, its more efficient to declare the type parameter once.
```java
public <T extends Animal> void takeThing(ArrayList<T> one, ArrayList<T> two)
```
# In generics, "extends" means "extends or implements"
The keyword "extends" really means "IS-A", and works for both calsses and interfaces.
```java
public static <T extends Comparable<? super T>> void sort(List<T> list
```
`<T extends Comparable...`
`Comparable` is an interface, so `T` must be a type that implements the `Comparable` interface.
It doesnt matter whether the thing on the right is a class or interface, you still say "extends".
