---
id: jpa-example
aliases: []
tags: []
---

## DAO implementation
```java
@Repository
public class StudentDAOImpl implements StudentDao {
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
```
