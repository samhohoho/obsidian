---
id: jpa
aliases: []
tags: []
---

[[hibernate]]

# What is JPA?
Jakarta Persistence API is a standard API for ORM.
A set of interfaces that require implementation to be usable.

One implementation is **Hibernate** (default).

## ORM
Oject-to-relational mapping,
mapping a Java class to a database table.

# Entity class
Must be annotated with `@Entity`.
Must have a public or protected no-arg constructor.

## Map class to database table
```java
@Entity
@Table(name="student")
public class Student {...}
```
## Map fields to database columns
```java
@Entity
@Table(name="student")
public class Student {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;
}
```
`@Column` is optional.
If not specified, the column name is the same name as Java field.
Same goes for `@Table`.

# `EntityManager` is a JPA helper object.
It is the main component for creating queries etc...
It is from JPA.

# Automatic data source configuration
Based on configs, Spring Boot will automatically create the beans:
`DataSource`, `EntityManager`,...
You can then inject these into your app, like DAO.

Spring Boot will automatically configure your data source,
based on entries from Maven pom file.
DB connection info from `application.properties`.

No need to give JDBC driver class name.
Spring Boot will automatically detect it based on data source URL.

# FAQ
## The query in HQL has no `select` clause
```java
List<Person> persons = session.createQuery(
    "from Person", Person.class
).getResultList();
```
The `select` clause is optional in Hibernate Query Language (HQL).
But it is required in strict JPQL.

## Hibernate/JPA and JDBC
JPA uses JDBC for all database communications.
Hibernate/JPA is just another layer of abstraction on top of JDBC.
