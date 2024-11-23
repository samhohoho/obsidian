---
id: faq
aliases: []
tags: []
---

# FAQ
## `@Bean` vs `@Component`
You can use @Bean to make an existing third-party class available to you Spring framework application context.

For example, S3Client is a regular Java class that provides a client interface to the AWS S3 service. However, it does not have the `@Component` annotation.

In order to share this object to Spring framework application context, we can wrap this class using the `@Bean` annotation. Then it becomes a singleton object and can be shared using dependency injection and `@Autowired`.
```java
@Bean
public S3Client remoteClient() {
    // Create an S3 client to connect to AWS S3
    S3Client s3Client = ...
}

@Service
public class ServiceImpl implements Service {
    @Autowired
    private S3Client remoteClient;
}
```
## `@Configuration` vs `@Component`
`@Component` is used to indicate a class is a Spring component.
A class that doesnt fit into specific categories like controllers, services, or repositories.
When annotated, Spring automatically detects and registers it as a bean in the application context during component scanning.
```java
@Component
public class MyComponent {
    // ...
}
```
`@Configuration` is used to define Java-based configuration classes.
To define beans and configure the Spring application context.
Useful when you need to configure complex beans or external dependencies.
```java
@Configuration
public class MyConfiguration {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```
## Defining bean in class annotated by `@SpringBootApplication`.
The `@SpringBootApplication` is a meta-annotation.
It is composed of the following annotations:
`@SpringBootApplication`, `@EnableAutoConfiguration`, and `@ComponentScan`.
Note the Spring Boot's version of `@Configuration`.
So, the bean is essentially in a `@Configuration` class.

## Why the AWS S3 client was not annotated with @Component?
When we are defining configuration beans in our class that is annotated with `@Configuration`,
we always use `@Bean` for methods in that class.
That way each method (S3Client) is an individual bean.

`@Component` is reserved for an entire class.

## What are the essential beans that are typically initialized at the launch?
These beans are essential for application's core functionality, configuration, or infra setup.
- DataSource.
    - It holds the configuration for the database connection and for database related operations.
- EntityManagerFactory.
    - Managing the persistence operations for applications using JPA and Hibernate.
- Application context.
    - A central interface that provides access to the beans and their configurations.
    - To ensure beans are managed correctly.
- TaskExecutor.
    - To manage the execution of tasks in the background for app that involves asynchronous processing.
- Springboot auto-configuration.
    - Springboot initializes beans related to auto-configuration classes.
    - To setup the required configuration for features like caching, security, and web services.
- Embedded web server.
    - For web application to serve incoming requests.
- Spring security configuration.
