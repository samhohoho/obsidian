---
id: jpql-example
aliases: []
tags: []
---
# Name Parameters
```java
public List<Student> theQuery = entityManager.createQuery
(
    "FROM Student WHERE lastName=:theData", Student.class
);

theQuery.setParameter("theData", theLastName);
return theQuery.getResultList();
```
# Strict JPQL
```java
TypedQuery<Student> theQuery = entityManager.createQuery
(
    "select s FROM Student s WHERE s.email LIKE '%luv2code.com'", Student.class
);
```
`s` is a reference to the entity/object.
# Full example
```java
public interface StudentDao {
    List<Student> findAll();
}
public class StudentDaoImpl implements StudentDao {
    private EntityManager entityManager;
    // ...
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        return theQuery.getResultList();
    }

@SpringBootApplication
public class CrudDemoapp {
    public static void main(String[] args) {SpringApplication.run(CrudDemoapp.class, args);}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            queryForStudents(studentDAO);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();
    }
}
```
