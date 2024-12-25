---
id: explain
aliases: []
tags: []
---
# Explain Output
- Columns
    - possible_keys (JSON: possible_keys)
        - Indicates the indexes MySQL can choose to find rows.
    - key (JSON: key)
        - The key (index) MySQL decides to use to look up rows.
        - One of the possible_keys indexes.
    - rows (rows)
        - Number of rows MySQL believes it must examine to execute the query.
    - Extra (none)
        - Information about how MySQL resolves the query.
        - https://dev.mysql.com/doc/refman/8.4/en/explain-output.html#explain-extra-information
    - type (access_type)
        - ref: All rows with matching index values are read from this table for each combination of rows from the previous tables.
    - Links
        - https://dev.mysql.com/doc/refman/8.4/en/explain-output.html
