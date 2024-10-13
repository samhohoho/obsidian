https://naveen-metta.medium.com/mastering-java-exception-handling-a-comprehensive-guide-a897b8020582

## Throwing Exceptions
```java
public void validateAge(int age) throws IllegalArgumentException {
    if (age < 0) {
        throw new IllegalArgumentException("Age cannot be negative");
    }
}
```
## Creating Custom Exceptions
Define custom exception classes by extending `Exception` or `RuntimeException` classes.
```java
public class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
```
## Propagating Exceptions: throws Keyword
When a method does not handle it, the caller must handle or propagate further.
```java
public void readFile(String filePath) throws FileNotFoundException, IOException {
    // Code that may throw exceptions
}
```
