---
id: faq
aliases: []
tags: []
---

## @Bean and @Component
- **`@Component` declares a class as a Spring-managed bean.**
    - Allows Spring to automatically detect and register it during component scanning.
    - Useful for classes you have control over.
    - Useful for Spring to manage without any additional configuration.
- **`@Bean` is a method-level annotation.**
    - Used within a `@Configuration` class.
    - Useful when you need to create a bean with specific configurations.
    - Useful when you are working with 3rd-party classes that you cannot modify.
    - Allow for more complex initialization logic.
