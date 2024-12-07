---
id: generics
aliases: []
tags: []
---
https://dev.java/learn/generics/intro/#raw-types
# Overview
- What?
    - Parameterized types (classes and interfaces).
    - Enable types to be parameters when defining classes, interfaces, and methods.
    - [Parametric polymorphism](https://en.wikipedia.org/wiki/Parametric_polymorphism)
- Why?
    - Allow the "outside world" to specify an actual type.
    - To re-use the same code with different inputs.
    - To write type-safe collections.
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
- Why?
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
# Raw types
- What?
    - A generic class or interface without any type arguments.
# Generic methods
- What?
    - Similar to generic type, but the type parameter's scope is limited to the method.
- Notes.
    - Static, non-static, and class constructors are allowed.
```java
public class Util {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }
}

Pair<Integer, String> p1 = new Pair<>(1, "apple");
Pair<Integer, String> p2 = new Pair<>(2, "pear");

boolean same = Util.<Integer, String>compare(p1, p2);
boolean same = Util.compare(p1, p2); // type inference
```
# Bounded type parameters
- What?
    - Allow the "inside world" to iuse a commonality.
    - Restrict the type.
    - A bound means the `T` must be `Number` or a subclass of `Number`.
- Note.
    - `extends` = `extends` or `implements`
- Links.
    - https://stackoverflow.com/a/30293011/17881174
```java
public <U extends Number> void inspect(U u){ // Only numbers
    System.out.println("U: " + u.getClass().getName());
}
```
## Multiple bounds
- What?
    - A subtype of all types listed in the bound.
- Notes.
    - The class must be specified first.
```java
Class A { /* ... */ }
interface B { /* ... */ }
interface C { /* ... */ }

class D <T extends A & B & C> { /* ... */ }
```
# Generics, inheritance, and subtypes
- What?
    - "is a" relationship, same with generics.
```java
Box<Number> box = new Box<Number>();
box.add(new Integer(10));   // OK
box.add(new Double(10.1));  // OK
```
## What type of argument does it accept?
```java
public void boxTest(Box<Number> n) { /* ... */ }
```
- Notes.
    - Not allowed to pass in `Box<Integer>` or `Box<Double>`.
    - `Box<Integer>` and `Box<Double>` are not subtypes of `Box<Number>`.
# Type inference
## Generic constructors
- What?
    - Constructors can be generic in both generic and non-generic classes.
```java
class MyClass<X> {
  <T> MyClass(T t) {
    // ...
  }
}

new MyClass<Integer>("")
```
- Notes.
    - The compiler infers the type `String` for the formal type parameter of the constructor.
# Examples
## Generic Methods and Bounded Type Parameters
```java
public static class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    protected final T data;
    protected final List<Node<T>> adj;

    public Node(T data) {
        this.data = data;
        adj = new ArrayList<Node<T>>();
    }

    @Override
    public int compareTo(Node<T> other) {
        return data.compareTo(other.data);
    }
}
```
- Notes.
    - Type parameter `T` is constrainted to types that implement `Comparable<T>`.
    To ensure `T` can be compared using the `compareTo` method.
    - The `Node` class implements `Comparable<Node<T>>`.
    Node instances can also be compared.
    - The comparison is delegated to the `compareTo` method.
    This method allows to compare `Node` instances based on their `data`.

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
