---
id: dependency-injection
aliases: []
tags: []
---

**Dependency injection is a process where objects define their dependencies. Then the container injects those dependencies when it creates the bean.**

Injection types:
- Contructor injection (recommended)
- Setter injection

Use setter injection when you have dependencies. If not provided, you can provide default logic.

# AutoWiring
Spring will look for a class that matches by type (class or interface).

Spring will scan for classes that's annotated with `@Components`.
And search for implementation and inject it as an dependency.

`@Component` annotation marks the class as a Spring Bean, making it a candidate for dependency injection.

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
`@Autowired` annotation tells Spring to inject a dependency.

**If you only have one constructor then `@Autowired` on constructor is optional.**

# FAQ
## `Autowired` vs `New` keyword
@Autowired honors the scope of the bean.
In Spring, all beans are singleton by default.
With singleton scope, Spring will not create a new instance every time.
Instead it will share the singleton reference.
