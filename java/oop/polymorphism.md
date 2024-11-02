---
id: polymorphism
aliases: []
tags: []
---

```java
Dog myDog = new Dog();
```
`Dog myDog` tells the JVM to allocate space for a **reference varaiable**.
`new Dog()` tells the JVM to allocate space for a new dog object on the garbage collectible heap.
Finally assigns the `new Dog` to the reference variable `myDog`.

With **polymorphism**, the reference type can be a superclass of the object type.
```java
Animal myDog = new Dog();
```

Using polymorphic arguments, declare the method parameter as a superclass type,
I can pass in any subclass object at runtime.
```java
class Vet {
    public void giveShot (Animal a) {
        a.makeNoise();
    }
}

class PetOwner {
    public void start() {
        Vet v = new Vet();
        Dog d = new Dog();
        v.giveShot(d);
    }
}
```
