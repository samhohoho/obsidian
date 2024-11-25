---
id: Bean
aliases: []
tags: []
---

[[java-spring/core/bean#`@Configuration` vs `@Component`|@Configuration vs @Component]]

When a method is annotated with `@Bean`, it serves as a factory method for creating a bean.
The method's return type represents the type of the bean, and the method name is the bean's name.
The bean return by this method is then managed by the Spring container.
```java
@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
```

# FAQ
- **`@Autowired` and `@Bean`**
    - Using `@Bean`, Spring automatically resolves the method paramaters by injecting the proper beans.
    - The absence of `@Autowired` is valid.
