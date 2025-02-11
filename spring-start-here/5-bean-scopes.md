---
id: 5-bean-scopes
aliases: []
tags: []
---
# Overview
- Scopes are the different approaches for creating beans and managing their life cycle.
# Singleton
- You will always get the same instance when you refer to a specific bean.
- Notes.
    - You can have more instances of the same type if they have different names.
        - For Spring, the singleton concept allows multiple instances of the same type.
        - Singleton means unique per name but not unique per app.
    - Using `@Bean` annotation to declare the bean.
        - The name of the method becomes the identifier of the bean.
```java
// Make sure only one instance of a type is created.
public class CommentService {
    public static CommentService getInstance() {
        if (instanceHasNotYetBeenCreated()) {
            createCommentServiceInstance();
        }

        return commentS ervice;
    }
}

// With Spring, you can define
// as many beans of the same type.
// Each beans is singleton.
@ Configuration
public class ProjectConfig {
    @Bean
    public CommentService commentService1() {
        return new CommentS ervice();
    }

    @Bean
    public CommentService commentService2() {
        return new CommentService();
    }
}
```
## Real-world scenarios
- Multiple componenets of the app can share an object instance.
- The most important thing is the beans must be immutable.
- Real-world app executes actions on multiple threads.
    - Multiple threads share the same object instance.
    - If threads change the instance, you encounter a race-condition scenario.
    - **Race condition**: when multiple threads try to change a shared resource.
    - Properly synchronize the threads is needed.
- Thread synchronization is needed for mutable singleton beans.
- Singleton beans arent designed to be synchronized, but app's backbone class design and delegating responsibilities.
### Defining beans as final
- Constructor DI is a good practice and preferred over field injection.
    - It makes the instance immutable.
## Using eager and lazy instantiation
- The default behavior is **eager instantiation**.
    - Spring creates all singleton beans when it initializes the context.
- **Lazy instantiation.**
    - It creates each instance the first time someone refers to the bean.
```java
@Service
@Lazy
public class CommentService {
    public CommentService() {
        System.out.println("CommentService instance created!");
    }
}
```
### Eager or lazy?
- Its more comfortable to be **eager**.
    - Able to detect issue when starting the app.
- In **lazy**, framework has to first check if the instance exists.
    - From performance point of view, its better to have the instances in the context ready.
    It spares some checks when one bean delegates to another.
- Often, the need for using **lazy** is a sign something might be wrong with the app's design.
    - It would be better if the app was designed in a modular way or as microservices.
    It helps developers deploy only what is needed.
# Prototype bean scope
- Every time you request a reference to a prototype-scoped bean, Spring creates a new object instance.
- Spring doesnt create and manage an object instance directly.
```java
@Configuration
public class ProjectConfig {
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public CommentService commentService() {
        return new CommentService();
    }
}
```
```java
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentRepository {
}
```
## Real-world scenarios
- `CommentProcessor` that processes the comments and validates them.
- A service uses the `CommentProcessor` object to implementa use case.
- But `CommentProcessor` stores the comment to be processed as an attribute,
and its methods change its attribute.
```java
public class CommentProcessor {
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void getComment() {
        return this.comment;
    }

    public void processComment() {
        // changing the comment attribute
    }

    public void validateComment() {
        // validating and changing the comment attribute
    }
}
```
### Does `CommentProcessor` need to be a bean?
- Suppose it needs to use an object `CommentRepository` to persist some data.
And `CommentRepository` is a bean.
- Then `CommentProcessor` needs to become a bean to benefit from the DI Spring offers.
```java
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentProcessor {
    @Autowired
    private CommentRepository commentRepository;

    // Omitted code
}
```
## Using `CommentProcessor` as prototype bean
```java
@Service
public class CommentService {
    @Autowired
    private ApplicationContext context;

    public void sendComment(Comment c) {
        // A new CommentProcessor instance is always provided here.
        CommentProcessor p =
            context.getBean(CommentProcessor.class);

        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);

        c = p.getComment();
        // do something further
    }
}
```
- Dont inject `CommentProcessor` directly into `CommentService` bean.
    - Becuz the `CommentService` bean is a singleton.
