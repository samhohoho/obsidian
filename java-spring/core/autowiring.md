---
id: autowiring
aliases: []
tags: []
---

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
