---
id: ultimate-superclass
aliases: []
tags: []
---

Head First Java 2nd Edition - C8 - pg208

**Every class extends class Object.**
without you ever having to say it.

Class object is the mother of all classes.
Its the superclass of everything.

**Any class that doesnt explicitly extend another class, implicitly extends `Object`.**

**Q: Why do we allow Object to be instiated like Animal class?**
The most common use of an instance of type Object is for thread synchronization.

**Q: Main purposes of the Object class?**
- To act as a polymorphic type for methods.
- To provide real method code at runtime.

**Q: Why not make all methods take and return type Object?**
It would defeat the whole point of type-safety.
With type-safety, Java guarantees that you wont use the wrong object.
Also, you are allowed to call the Object methods.

**Q: What happens when you use `ArrayList<Object>`?**
```java
ArrayList<Object> list = new ArrayList<Object>();
Dog dog = new Dog();
list.add(dog);

Dog d = list.get(0); // wont work
```
The compiler knows only that the object inherits from Object but it doesnt know its a Dog.
