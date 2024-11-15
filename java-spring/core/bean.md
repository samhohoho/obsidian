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
