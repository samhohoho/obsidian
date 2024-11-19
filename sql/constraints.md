---
id: conditions
aliases: []
tags: []
---

# `NOT IN`, `IN` or `OR`
```sql
SELECT *
FROM your_table
WHERE name = 'john' OR name = 'doe';

SELECT *
FROM your_table
WHERE name IN ('john', 'doe');

SELECT *
FROM your_table
WHERE name NOT IN ('john', 'doe');
```
# `NOT BETWEEN`, `BETWEEN`, `AND`
```sql
col_name BETWEEN 1.5 AND 10.5;
```
# `LIKE`, `NOT LIKE`, `%`, `_`
```sql
col_name LIKE "ABC";
col_name LIKE "AN_"; # Matches "AND" but not "AN"
col_name LIKE "%ABC%";
```
