MyBatis is a first class persistence framework.
map primitives, Map interfaces and Java POJOs (Plain Old Java Objects) to database records.
If you are completely new to database access in Java, [https://www.marcobehler.com/guides/a-guide-to-accessing-databases-in-java](https://www.marcobehler.com/guides/a-guide-to-accessing-databases-in-java)

sql session

[Scope and Life-cycle](https://mybatis.org/mybatis-3/getting-started.html#scope-and-lifecycle)
ransactional SqlSessions and mappers and inject them directly into your beans so you can just forget about their lifecycle.
the best scope for instances of SqlSessionFactoryBuilder is method scope (i.e. a local method variable).
XML parsing resources are freed up for more important things.
