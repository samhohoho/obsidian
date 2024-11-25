---
id: SpringBootApplication
aliases: []
tags: []
---

https://docs.spring.io/spring-boot/reference/using/using-the-springbootapplication-annotation.html

- Devs like to use auto-configuration, component scan and extra configuration.
    - `@EnableAutoConfiguration`: enable auto-configuration mechanism.
    - `@ComponentScan`: enable `@Component` scan on the package where the application is located.
    - `@SpringBootConfiguration`.
        - enable registration of extra beans in the context.
        - import of additional configuration class.
        - alternative to `@Configuration` that aids configuration detection in integration tests.
