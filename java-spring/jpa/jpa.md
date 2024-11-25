---
id: jpa
aliases: []
tags: []
---

[[hibernate]], [[Transactional|@Transactional]]

# Links
[JPA/Hibernate Persistence Context](https://www.baeldung.com/jpa-hibernate-persistence-context)

# What is JPA?
Jakarta Persistence API is a standard API for ORM.
A set of interfaces that require implementation to be usable.

One implementation is **Hibernate** (default).

## ORM
Oject-to-relational mapping,
mapping a Java class to a database table.

# `EntityManager` is a JPA helper object.
- **EntityManager is the interface provided by JPA.**
    - Whenever we use the EntityManager, we are actually interacting with the **persistent context**.
- **EntityManager as the entry point to persistent context.**
    - It allows to perform various operations and manages the entities lifecycle.
    - Including persisting, merging, removing, and querying them.
- **Automatic establishment of persistence context.**
    - When creating EntityManager, it automatically creates a persistent context associated with the current transaction, especially using transaction-scoped context (default).
    - Any operations performed within the scope of this transaction will be managed by the associated persistent context.
- It is from JPA.
- **Data source configuration.**
    - JPA EntityManager and Data Source are automatically created by Spring Boot,
    based on the file: `application.properties`.

## Persistent context as a cache
- **Persistent context as a cache.**
    - Acts as a **first-level cache** for entities, storing the state of entities that have been read from or written to the db within the current transaction.
    - The **first-level cache** where all the entities are fetched from db or saved to db.
    - It sits between application and persistent storage.
    - Once an entity is read from db into the persistent context, subsequent requests for the same entity within the same persistent context will not result in additional db queries.
- **Synchronization with db.**
    - Keeps track of changes made to managed entities and sync these changes with db upon transaction commit.
    - It is part of the ORM layer and ensures entities in the application are synchronized with the db.
    - Any pending changes are rolled back if the transaction is rolled back.
- **Lifecycle tied to transaction.**
    - When Spring starts a transaction it creates a new persistent context.
    - It is active during a transaction and ends when transaction is commited or rolled back.
- **A concept within JPA.**
    - Represents the set of managed entities that are associated with a certain EntityManager.
    - Ensures there is only one instance of each managed entity within its scope, maintaining the integrity of the object graph and preventing issues (stale data, conflicting updates...).
```
Application -> EntityManager -> PersistenceContext -> Database
```
## EntityManager and PersistenceContext
- Basically EntityManager (operator) perform operations on PersistenceContext (resources/workspace).
    - EntityManager is like a skilled technician working in a lab.
    - PersistenceContext is the lab itself, will tools and materials.

# Data Access Object design pattern
Responsible for interfacing with db.
Common design pattern.

DAO needs a JPA Entity Manager.
We can autowire/inject JPA Entity Manager into DAO.

# JpaRepository
Spring Data JPA has a JpaRepository interface.
It provides JPA database access with minimal coding.

# Automatic data source configuration
Based on configs, Spring Boot will automatically create the beans:
`DataSource`, `EntityManager`,...
You can then inject these into your app, like DAO.

Spring Boot will automatically configure your data source,
based on entries from Maven pom file.
DB connection info from `application.properties`.

No need to give JDBC driver class name.
Spring Boot will automatically detect it based on data source URL.

