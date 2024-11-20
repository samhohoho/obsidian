---
id: jpa
aliases: []
tags: []
---

[[hibernate]]

# What is JPA?
Jakarta Persistence API is a standard API for ORM.
A set of interfaces that require implementation to be usable.

One implementation is **Hibernate**.

`EntityManager` is a JPA helper object.

# Hibernate/JPA and JDBC
JPA uses JDBC for all database communications.
Hibernate/JPA is just another layer of abstraction on top of JDBC.

# FAQ
## The query in HQL has no `select` clause
```java
List<Person> persons = session.createQuery(
    "from Person", Person.class
).getResultList();
```
The `select` clause is optional in Hibernate Query Language (HQL).
But it is required in strict JPQL.
