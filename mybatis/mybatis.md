---
id: mybatis
aliases: []
tags: []
---
## String substitution
- use `#{}`
- Its not safe to accept input from a user and supply it to a statement unmodified.
This leads to potential SQL injection.
```sql
ORDER BY ${columnName}
```
```java
@Select("select * from user where ${column} = #{value}")
User findByColumn(@Param("column") String column, @Param("value") String value);
```
# ResultMap
## constructor
