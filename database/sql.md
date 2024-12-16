---
id: sql
aliases: []
tags: []
---
# SELECT
## AS
```sql
SELECT city, (temp_hi+temp_lo)/2 AS temp_avg, date FROM weather;
```
```
     city      | temp_avg |    date
---------------+----------+------------
 San Francisco |       48 | 1994-11-27
 San Francisco |       50 | 1994-11-29
 Hayward       |       45 | 1994-11-29
(3 rows)
```
# VIEWS
- Gives a name to a query and refer it like an ordinary table.
```sql
CREATE VIEW myview AS
    SELECT name, temp_lo, temp_hi, prcp, date, location
        FROM weather, cities
        WHERE city = name;

SELECT * FROM myview;
```
# Constraints
## Foreign keys
- The values in a column must match the values in another table.
- Maintaining referential integrity bwtween two tables.
- https://www.postgresql.org/docs/current/ddl-constraints.html#DDL-CONSTRAINTS-FK
```sql
CREATE TABLE products (
    product_no integer PRIMARY KEY,
    name text,
    price numeric
);

CREATE TABLE orders (
    order_id integer PRIMARY KEY,
    product_no integer REFERENCES products (product_no),
    quantity integer
);
```
```sql
// Shorten
CREATE TABLE orders (
    order_id integer PRIMARY KEY,
    product_no integer REFERENCES products,
    quantity integer
);
```
### Constrain and reference a group of columns
```sql
CREATE TABLE t1 (
  a integer PRIMARY KEY,
  b integer,
  c integer,
  FOREIGN KEY (b, c) REFERENCES other_table (c1, c2)
);
```
### Self-referential foreign key
- What?
    - A table that references the primary key of the same table.
- Why?
    - To have rows to represent nodes of a tree structure.
    - To establish hierarchical/recursive relationships within the same entity.
    - It simplifies queries and schema design by avoiding additional tables for parent-child relationships.
- cons.
    - Recursive relationships can make queries complex and potentially inefficient for deep hierarchies in large datasets.
- Example.
    - Finding all employees under a specific manager.
    - Fetching all subcategories for a given category.
```sql
CREATE TABLE Employee (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    manager_id INT,
    FOREIGN KEY (manager_id) REFERENCES Employee (id)
);
```
```
Employee Table
+----+----------+-------------+
| ID | Name     | Manager_ID  |
+----+----------+-------------+
| 1  | Alice    | NULL        |  <-- Alice has no manager (top-level)
| 2  | Bob      | 1           |  <-- Bob reports to Alice
| 3  | Charlie  | 2           |  <-- Charlie reports to Bob
+----+----------+-------------+
```
