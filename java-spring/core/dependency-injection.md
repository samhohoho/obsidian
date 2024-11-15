---
id: dependency-injection
aliases: []
tags: []
---

# Dependency Injection

**Dependency injection is a process where objects define their dependencies. Then the container injects those dependencies when it creates the bean.**

Injection types:
- Contructor injection (recommended)
- Setter injection

Use setter injection when you have dependencies. If not provided, you can provide default logic.

## Field Injection ... no longer cool
It makes the code harder to test.

# AutoWiring
`@Autowired` annotation is a key feature in Spring that facilitates dependency injection, allowing Spring to automatically resolve and inject the required beans into your classes.

**Spring will look for a class that matches by type (class or interface) of the property or constructor parameter.**
If you dont mention `@Autowired`, Spring will not know it should inject a dependency into that field or constructor. As a result, the field remains uninitialized, leading to a `NullPointerException` if you try to use it.

**If you only have one constructor then `@Autowired` on constructor is optional.**

Spring will scan for classes that's annotated with `@Components`.
And search for implementation and inject it as an dependency.

**`@Component` annotation marks the class as a Spring Bean**, making it a candidate for both component scanning and dependency injection, which means Spring will detect this class and manage its lifecycle.

Create a constructor in the class for injections:
```java
public interface Coach {
    String getDailyWorkout();
}

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "..."
    }
}

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }
}
```
If the argument is the interface that is implemented by a class that is annotated, then it will be of type of that class.
In this example, where argument is an interface, and the type of the bean is `CricketCoach`.

# FAQ
## `Autowired` vs `New` keyword
@Autowired honors the scope of the bean.
In Spring, all beans are singleton by default.
With singleton scope, Spring will not create a new instance every time.
Instead it will share the singleton reference.

## Wym by Wiring?
Creating a link between RestController and Coach, making Coach available at the moment of creation of the controller.

## Does Spring create the object of a class that is annotated with @Component?
Yes. It will create a bean out of that class.
If there is no @Component annotation, you will get exceptions like:
```
    Parameter 0 of constructor in com.luv2code.springcoredemo.rest.DemoController
required a bean of type 'com.luv2code.springcoredemo.common.Coach' that could not be found.
    Action:
Consider defining a bean of type 'com.luv2code.springcoredemo.common.Coach' in your configuration.
```
