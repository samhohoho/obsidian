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

# Bean lifecycle methods / hooks
- You can add custom code during **bean initialization**.
    - Calling custom business logic methods.
    - Setting up handles (db, sockets, file etc).
- Add custom code during **bean destruction**.

For instance, it can be used to load some initial data into the db when the app starts.
This is typically used for unit/integration testing.
However, this is not the standard practice on large scale enterprise apps.
```java
@Component
public class TrackCoach implements Coach {
    @PostConstruct
    public void doMyStartupStuff() {...}

    @PreDestroy
    public void doMyCleanupStuff() {...}
}
```
## Prototype scope - destroy lifecycle method
**Spring does not call the destroy method.**
**Spring does not manage the complete lifecycle of a prototype bean.**

The container instantiates, configures, assembles a prototype object, and hands it to the client.

## FAQ
### Why not calling the methods in the constructor?
1. Dependency injection readiness
    - Calling initialization methods directly from constructor risk accessing uninitialized dependencies.
    - @PostConstruct ensures that dependencies are fully initialized before the initialization method is invoked.
2. Avoid circular dependency issues:
    - It happens when initialization method call methods on other beans that depend on the current bean.
    - @PostConstruct ensures that all dependencies are resolved before initialization.

