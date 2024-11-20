---
id: hibernate
aliases: []
tags: []
---

[[jpa]]

# Overview
**Hibernate is a framework for persisting/saving Java objects in database.**

Benifits:
- Handles low-level SQL.
- Minimize JDBC code.
- Provides Object-to-Relational Mapping (ORM).

## ORM
The dev defines mapping between Java class and db table.

# Hibernate has two ways to access data for an entity
1. Field access:
    - By default, Hibernate will access the fields directly using introspection and reflection.
    - It can update the fields regardless of visibility (public, private, protected)
