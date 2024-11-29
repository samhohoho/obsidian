---
id: jpql
aliases: []
tags: []
---
[[jpql-example]]
# Overview
- What?
    - Query language for retrieving objects.
    - Similar to concept to SQL.
    - JPQL is based on **entity name** and **entity fields**,
    as opposed to the direct table names and table columns.
- Named parameters.
    - prefixed with a colon.
    - A placeholder that is filled in later.
- `SELECT` clause.
    - The Hibernate implementation is lenient and allows HQL (Hibernate Query Language).
    - For strict JPQL, the `SELECT` clause is required.
