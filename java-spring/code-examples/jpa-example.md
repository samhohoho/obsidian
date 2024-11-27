---
id: jpa-example
aliases: []
tags:
  - example
---

## DAO implementation
```java
public interface StudentDao {
    void save(Student student);
    Student findById(Integer id);
}

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

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }
}

@SpringBootApplication
public class CrudDemoapp {
    public static void main(String[] args) {SpringApplication.run(CrudDemoapp.class, args);}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            createStudent(studentDAO);
        }
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        Student tempStudent = new Student(name = "paul");

        // save the student object
        studentDAO.save(tempStudent);
    }
}
```
