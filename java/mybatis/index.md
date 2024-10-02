https://mybatis.org/mybatis-3/getting-started.html

Links: [SqlSession](https://mybatis.org/mybatis-3/getting-started.html#sqlsession), 

SqlSessionFactory
It's a best practice to not rebuild the SqlSessionFactory multiple times in an application run.
The best scope of SqlSessionFactory is application scope.
Use a Singleton pattern or Static Singleton pattern.


