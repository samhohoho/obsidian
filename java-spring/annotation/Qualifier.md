---
id: Qualifier
aliases: []
tags: []
---

```java
@Autowired
public void setCoach(@Qualifier("cricketCoach") Coach theCoach) {
    myCoach = theCoach;
}
```

# FAQ
## Why not just give it an actual class?
By using `@Qualifier`, you maintain the type consistency of the dependency, which can be useful when you have other components relying on the same type.

It is also considered a best practice to "code to the interface".

"Coding to the interface" is a principle commonly associated with OOP and is widely adopted in many software development methodologies, such ah SOLID principles, dependency injection, and design patterns like Strategy pattern.

By coding to the interface, you introduce a level of abstraction and separation between components, which promotes modularity, flexibility, and maintainability of the codebase.
It allows to change implementations easily, facilitates testing and mocking, enables code reuse and promotes loose coupling.

It emphasize the importance of coding against abstractions rather than concrete implementations.
