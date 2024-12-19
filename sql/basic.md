---
id: basic
aliases: []
tags: []
---
# WHERE
- Operator:
    - Numerical: `=, !=, <, <=, >, >=`
        - `col_name != 4`
    - Numerical range: `BETWEEN … AND …` & `NOT BETWEEN … AND …`
        - `col_name BETWEEN 1.5 AND 10.5`
        - `col_name NOT BETWEEN 1 AND 10`
    - Not-exist/exist in the list: `NOT IN (…)` & `IN (…)`
        - `col_name NOT IN (1, 3, 5)`
        - `col_name NOT IN ('john', 'doe');`
        - `col_name IN (2, 4, 6)`
        - `col_name IN (2, 4, 6)`
    - Exact comparison: `=`
        - `col_name = "abc"`
    - Exact inequality comparison: `=` or `<>`
        - `col_name != "abcd"`
    - Exact string comparison: `LIKE` or `NOT LIKE`
        - `col_name LIKE "ABC"`
        - `col_name NOT LIKE "ABCD"`
        - Match zero or more chars: `%`
            - `col_name LIKE "%AT%"`
            (matches "AT", "ATTIC", "CAT" or even "BATS")
        - Match a single character: `_`
            - `col_name LIKE "AN_"`
            (matches "AND", but not "AN")
    - Checking for null: `IS NULL` or `IS NOT NULL`
        - `column IS NULL`
# Notes
## Null values
- Good to reduce the possibility if `NULL` values.
- Becuz certain functions behave differently with null values.
- Alternatives are 0, empty string or others.
