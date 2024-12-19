---
id: joins
aliases: []
tags: []
---

# `INNER JOIN`
- Combine row data across two separate tables using unique key.
- `INNER JOIN` = `JOIN`
- `LEFT JOIN` = `LEFT OTHER JOIN`: Keep left.
```sql
SELECT column, another_table_column, …
FROM mytable
INNER/LEFT/RIGHT/FULL JOIN another_table 
    ON mytable.id = another_table.id
WHERE condition(s)
ORDER BY column, … ASC/DESC
LIMIT num_limit OFFSET num_offset;
```

