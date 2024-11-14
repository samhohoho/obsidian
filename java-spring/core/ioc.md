---
id: ioc
aliases: []
tags: []
---

# Overview

**IoC container is a framework for implementing automated dependency injection.**
**Basically an object factory.**

Primary functions:
- Create and manage objects (inverse of control).
- Inject object dependencies (dependency injection).

Dependency injection is a specialized form of IoC.
Objects define their dependencies through constructor arguments, arguments to a factory method.
Then the container injects those dependencies when it creates the bean.

`ApplicationContext` interface represents the **Spring IoC container**.
Responsible for instantiating, configuring, and assembling the beans.
It get instruction from configuration metadata (annotated component class, classes with factory methods, or XML).

In most scenario, not required to instantiate Spring IoC containter.
In Springboot scenario, the application context is implicitly bootstrapped.

# Configuration Metadata

It tells the Spring container how to instantiate, configure, and assemble the components in your application.

Configuring Spring container:
- XML configuration file (legacy)
- Java annotations
- Java source code

Using Java-based configuration:
**Annotation-based configuration**
Define beans using annotation-based configuration metadata on component classes.

**Java-based configuration**
Define beans external to classes.
See `@Configuration`, `@Bean`, `@Import`, `@DependsOn`.

Java configuration typically uses `@Bean`-annotated methods within a `@Configuration` class.

Typically, one does not configure fine-grained domain objects in the container, becuz it is the responsibility of repositories and business logic to create and load domain objects.
