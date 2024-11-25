---
id: entity
aliases: []
tags: []
---

- **Marks the class as an entity.**
    - Entity is a Java class, a persistent Java object.
    - It is mapped to a table in the db.
    - JPA will scan for this annotation and include it in its persistence context.
    - Each instance represents a row in that table.

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;
}
```
`@Column` is optional.
If not specified, the column name is the same name as Java field.
Same goes for `@Table`.

