---
id: faq
aliases: []
tags: []
---

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

## EntityManager vs JpaRepository
Use `EntityManager` for low-level control and flexibility.
Provides low-level access to JPA and work directly with JPA entities.
Complex queries such as native SQL queries or stored procedure calls.

`JpaRepository` for high-level of abstraction.
Provides common CRUD operations out of the box.
Can also create custom queries using `@Query`.
