---
id: bean
aliases: []
tags: []
---

[[ioc|Spring IoC container]]

# Overview
A Spring Bean is just a regular Java class that is managed by Spring.

A Spring IoC container manages one or more beans.

**Bean are created with the configuration metadata supplied to the container.**

In container, bean definitions are represented as `BaseDefinition` objects, which contain the following metadata:
- class name: actual implementation class of the bean.
- Bean behavioral configuration elements: how the bean behave in the container (scope, lifecycle ...).
- References to other beans, aka **dependencies**.
- Other configuration settings to set in new object (size limit of the pool, or number of connection to use in a bean that manages a connection pool).

# Lazy Initialization
By default, when application starts, all beans are initialized (@Component, etc...).
Spring will create an instance of each and make them available.

Initialize the bean only when it is explicitly requested.
```jav
@Component
@Lazy
public class TrackCoach implements Coach {
    ...
}
```
**Pros**
May help with faster startup if you have large number of components.

**Cons**
- Increased latency for first request.
    - The delay is due to the need to be created at runtime.
- Complexity and debugging
    - Difficult to trace the sequence of bean creation.
- Potential for runtime errors.
    - Its possible to encounter runtime errors related to bean creation and initialization.
    - Difficult to catch configuration issues during startup phase.
- Increased memory usage.
- Thread safety concerns.
    - If multiple threads try to access and initialize beans simultaneously, it may lead to unpredictable behavior or race conditions.
- May not discover configuration issues untill too late.
- Need to make sure you have enough memory for all beans.

**You should profile your application before configuring lazy Initialization.
Avoid the common pitfall of premature optimization.**

## Global configuration
```
spring.main.lazy-initialization=true
```
All beans are lazy.

# Bean scopes
Scope refers to the lifecycle of a bean.
How long does it live? How many instances are created? How is the bean shared?

**Default scope is singleton.**
Spring Container creates only one instance of the bean.
It is cached in memory.
All dependency injections for the bean will reference the same bean.

## Explicitly specify bean scope
```java
@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CricketCoach {}
```
Additional bean scopes:
- singleton
- prototype
    - creates a new bean instance for each container request.
    - new object instance for each injection.
- request
    - scoped to an HTTP web request. Only used for web apps.
- session
    - scoped to an HTTP web session. Only for web apps.
- application
    - scoped to web app ServletContext. Only for web apps.
- websocket
    - scoped to a web socket.

## Real usage of a prototype scope bean
1. Stateful objects
    - require each instance to maintain its own state.
    - for example, shopping cart.
2. Thread safety
    - can be used in multi-threaded app.
    - to ensure each thread gets its own instance of the bean.
3. Temporal or short-lived objects
    - can be discarded after use.
    - a bean that represents a one-time-use token.
4. Objects with changing state.
    - a game character.
5. User sessions.
    - requires its own instance.
    - to ensure that each instance doesnt interfere with other users' data.
6. Thread pool workers.
    - ensure worker threads dont interfere.

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
