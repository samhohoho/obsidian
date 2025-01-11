---
id: 4-abstractions
aliases: []
tags: []
---
- Analogy
    - Using a ride-sharing app.
        - I don’t care whether a car or a spaceship comes to pick me up if I reach the destination in time.
        - The ride-sharing app is an interface.
        - The customer and the driver are decoupled through the app (interface).
        - The customer doesn’t know who the driver is nor which car will pick them up.
- Notes
    - An object only needs to specify what it needs and stay completely unaware of how the what is implemented.
```java
public class DeliveryDetailsPrinter {
    private S orter sorter;
        public DeliveryDetailsPrinter(S orter sorter) {
        this.sorter = sorter;
    }
    public void printDetails() {
        sorter.sortDetails();
        // printing the delivery details
    }
}
```
- Naming convention
    - `proxies`: to establish communication with something outside the app.

![[Pasted image 20250108142835.png]]
# Without Spring Framework
## CommentRepository interface
```java
public interface CommentRepository {
    void storeComment(Comment comment);
}

public class DBCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
```
## CommentNotificationProxy interface
```java
public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}

public class EmailCommentNotificationProxy
    implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification for comment: "
                            + comment.getText());
    }
}
```
## Implementing the CommentService object
```java
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(
            CommentRepository commentRepository,
            CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
```
## Main class
```java
public class Main {
    public static void main(String[] args) {
        var commentRepository =
            new DBCommentRepository();
        var commentNotificationProxy =
            new EmailCommentNotificationProxy();
        var commentService =
            new CommentService(
                commentRepository, commentNotificationProxy);
        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");
        commentService.publishComment(comment);
    }
}
```
# Using dependency injection with abstractions
## Deciding which objects should be part of the Spring context
- Does this object need to be managed by the framework?
    - Add the object to the Spring context if it has a dependency or its a dependency itself.
- Notes.
    - Spring uses constructor to create the bean and injects references from its context in the parameter when creating instance.
## Making the `CommentService` class a component
- Two dependencies: interfaces `CommentRepository` and `CommentNotificationProxy`.
    - Spring searches in its context for beans that implemented these interfaces.
```java
@Component // Spring creates a bean of this class and adds it to its context.
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    // Spring uses constructor to create the bean
    // and injects references from its context
    // in the parameter when creating the instance.
    public CommentService(
        CommentRepository commentRepository,
        CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
```
## Using `@ComponentScan` in the configuration class
- Notes.
    - Use `basePackageClasses` attribute to directly specify the classes.
    - The disadvantage of `basePackages` is not realizing the value of `@ComponentScan` after renaming a package.
        - Using `basePackageClasses` might write more, but the app wont compile if `@ComponentScan` value is not updated.
```java
@Configuration
@ComponentScan(
    basePackages = {"proxies", "services", "repositories"}
)
public class ProjectConfiguration {
}
```
## The Main class
- We dont create the instance of the `CommentService` object and its dependencies ourselves.
```java
public class Main {
    public static void main(String[] args) {
        var context =
            new AnnotationConfigApplicationContext(
                ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Laurentiu");
        comment.setText("Demo comment");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
```
# Different ways of using dependency injection with abstraction.
## Field dependency injection with `@Autowired`.
- Spring uses the default constructor to create the instance of the class and inject the 2 dependencies from its context.
```java
@Component
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
```
## `@Bean` methods in the configuration class.
```java
@Configuration
public class ProjectConfiguration {

    @Bean
    public CommentRepository commentRepository() {
        return new DBCommentRepository();
    }

    @Bean
    public CommentNotificationProxy commentNotificationProxy() {
        return new EmailCommentNotificationProxy();
    }

    @Bean
    public CommentService commentService(
        CommentRepository commentRepository,
        CommentNotificationProxy commentNotificationProxy) {
        return new CommentService(commentRepository,
            commentNotificationProxy);
    }
}
```
