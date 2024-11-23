---
id: todo
aliases: []
tags: []
---

# Factory Methods
Spring can also create beans using factory methods, which are methods annotated with @Bean in a @Configuration class.
```java
@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        System.out.println("Creating MyBean from factory method");
        return new MyBean();
    }
}
```
